package Utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;    

public class DataUtils {    
	
//	Retorna uma data futura que será a data atual mais os dias informados por parâmetro
	public String criaDataComDiferencaDias(long diferencaDias) {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	   LocalDateTime now = LocalDateTime.now();
	   return dtf.format(now.plusDays(diferencaDias)).toString();
	  }
	
	public String criarDataAtual() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		   LocalDateTime now = LocalDateTime.now();
		   return dtf.format(now);
	}
	 
}
