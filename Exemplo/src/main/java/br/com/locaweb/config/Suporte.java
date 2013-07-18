package br.com.locaweb.config;


import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import com.thoughtworks.selenium.SeleneseTestCase;

public class Suporte extends SeleneseTestCase {
	String FILE_XLS = "";
	String ENCODING_FILE_XLS = "Cp1252";
	Workbook workbook = null;
	WorkbookSettings ws = null;
	File fileXLS = null;
	Sheet sheet = null;
	
	String abaPlanilha = "";
	int linhas = 0;
	int colunas = 0;
	int linhaAtual = 1;

	public int getLinhas() {
		return linhas;
	}

	public void setLinhaAtual(int linhaAtual) {
		this.linhaAtual = linhaAtual;
	}

	public int getLinhaAtual() {
		return linhaAtual;
	}	
	
	public Suporte(String abaDaPlanilha, String arquivoExcel) {
		super();
		FILE_XLS = arquivoExcel;
		abaPlanilha = abaDaPlanilha;

		if (!FILE_XLS.equalsIgnoreCase("null")) {
			coluna("carga");
		}
	}
	
	public String coluna(String coluna) {
		if ("carga".equalsIgnoreCase(coluna)) {
			fileXLS = new File(FILE_XLS);

			if ("null".equalsIgnoreCase(FILE_XLS)) {
				fail("Informe o diretório e o nome do arquivo .xls na variável \"FILE_XLS\". Exemplo: \"C:/datapool.xls\"");
				if (fileXLS.exists()) {
					fail("Não existe o arquivo .xml dentro do diretório informado!");
				}
			}

			try {
				ws = new WorkbookSettings();
				ws.setEncoding(ENCODING_FILE_XLS);
				workbook = Workbook.getWorkbook(fileXLS, ws);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			boolean contains = true;
			for (int i = 0; i < workbook.getSheetNames().length; i++) {
				if (workbook.getSheetNames()[i].equalsIgnoreCase(abaPlanilha.toLowerCase())) {
					contains = false;
					break;
				}
			}
			if (contains) {
				fail("Não existe a aba (" + abaPlanilha + ") no arquivo informado!");
			}
			
			sheet = workbook.getSheet(abaPlanilha);
			linhas = sheet.getRows();
			colunas = sheet.getColumns();
		}
		if ("carga".equalsIgnoreCase(coluna))
			return null;

		for (int i = 0; i < colunas; i++) {
			Cell colunasXML = sheet.getCell(i, 0);
			if (coluna.equalsIgnoreCase(colunasXML.getContents()))
				return sheet.getCell(i, linhaAtual).getContents();
		}
		fail("A coluna \"" + coluna + "\" não exite no arquivo excel!");
		return null;
	}

}
