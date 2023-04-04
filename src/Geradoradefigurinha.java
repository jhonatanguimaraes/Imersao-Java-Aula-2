import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Geradoradefigurinha {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem

        //InputStream inputStream = new FileInputStream(new File("entrada/serie_stranger_things.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        
        BufferedImage imagemAntiga = ImageIO.read(inputStream);

        //cria nova imagem em memória com transparência e com tamanho novo

        int largura = imagemAntiga.getWidth();
        int altura = imagemAntiga.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemAntiga, 0, 0, null);

        //configurar a fonte

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);


        //escrever uma frase na nova imagem


        graphics.drawString("TOPZERA", 100, novaAltura - 64);
        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    
}
}

