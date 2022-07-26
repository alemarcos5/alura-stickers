import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		
		
		// fazer uma conexão HTTP e buscar os top 250 filmes
		//String url = "https://alura-filmes.herokuapp.com/conteudos";
		//ExtratorDeConteudodo extrator = new ExtratorDeConteudodoIMDB();
		
		String url = "https://api.nasa.gov/planetary/apod?api_key=UlmKiJdhY86THffoz8gOkT2aESOSmkM5vd5UAC37&start_date=2022-05-01&end_date=2022-05-07";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		
		//String url = "https://alemarcos5-linguagens.herokuapp.com/linguagens";
		//ExtratorDeConteudo extrator = new ExtratorDeConteudodoIMDB();
		
		var http = new ClienteHttp(); 
		String json = http.buscaDados(url);
		
		// exibir e manipular os dados
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		for (int i = 0; i < conteudos.size(); i++) {

			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String titulo = conteudo.getTitulo();

			var geradora = new GeradoraDeFigurinhas();
			geradora.cria(inputStream, titulo);

			System.out.println(titulo);			
			System.out.println();			
			//System.out.println(filme.get("imDbRating"));			
			//System.out.println();			
		}
	}

}
