package com.ciscos.project.utils;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorBlind {

    public static Color filter(Color original, int mode) {
        if (mode == 0) return original;

        float[] rgb = original.getRGBColorComponents(null);
        float r = rgb[0], g = rgb[1], b = rgb[2];
        int alpha = original.getAlpha(); // preserva a transparência

        Color filtrada;

        switch (mode) {
            case 1: // Protanopia
                filtrada = new Color(
                    clamp((0.625f * r) + (0.375f * g), 0, 1),
                    clamp((0.7f * r) + (0.3f * g), 0, 1),
                    b
                );
                break;
            case 2: // Deuteranopia
                filtrada = new Color(
                    clamp((0.567f * r) + (0.433f * g), 0, 1),
                    clamp((0.558f * r) + (0.442f * g), 0, 1),
                    b
                );
                break;
            case 3: // Tritanopia
                filtrada = new Color(
                    r,
                    clamp((0.95f * g) + (0.05f * b), 0, 1),
                    clamp((0.433f * g) + (0.567f * b), 0, 1)
                );
                break;
            default:
                filtrada = original;
        }

        // Constrói nova cor com alpha preservado
        return new Color(filtrada.getRed(), filtrada.getGreen(), filtrada.getBlue(), alpha);
    }

    private static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static BufferedImage aplicarFiltroDaltonismo(BufferedImage imagem, int modo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = imagem.getRGB(x, y);
                Color corOriginal = new Color(rgb, true); // preserva alpha
                Color corConvertida = filter(corOriginal, modo);
                novaImagem.setRGB(x, y, corConvertida.getRGB());
            }
        }

        return novaImagem;
    }

    public static ImageIcon colorblindimage(URL path) {
        BufferedImage imagemOriginal = null;
        try {
            imagemOriginal = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (imagemOriginal == null) {
            System.err.println("Imagem não pôde ser carregada: " + path);
            return null;
        }

        BufferedImage imagemFiltrada = aplicarFiltroDaltonismo(imagemOriginal, Context.getColorblind());

        return new ImageIcon(imagemFiltrada);
    }
    
    public static JLabel colorblindGif(URL path) {
        ImageInputStream stream = null;
        try {
            ImageReader reader = ImageIO.getImageReadersByFormatName("gif").next();
            stream = ImageIO.createImageInputStream(path.openStream());
            reader.setInput(stream);

            List<BufferedImage> frames = new ArrayList<>();
            int numFrames = reader.getNumImages(true);

            for (int i = 0; i < numFrames; i++) {
                BufferedImage frame = reader.read(i);
                BufferedImage filtrado = aplicarFiltroDaltonismo(frame, Context.getColorblind());
                frames.add(filtrado);
            }

            return criarImageIconAnimado(frames, 80);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (stream != null) {
                try { stream.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
        
        public static JLabel criarImageIconAnimado(List<BufferedImage> frames, int delayMs) {
            JLabel label = new JLabel(new ImageIcon(frames.get(0)));

            Timer timer = new Timer(delayMs, new ActionListener() {
                int index = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    index = (index + 1) % frames.size();
                    label.setIcon(new ImageIcon(frames.get(index)));
                }
            });

            timer.start();
            return label;
        }
}
