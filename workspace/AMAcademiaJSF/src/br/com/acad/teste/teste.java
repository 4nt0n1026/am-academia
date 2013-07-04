package br.com.acad.teste;



public class teste {
	public static void main(String[] args) {
		for(int i=1; i<51; i++){
			System.out.println("ProfessorFunc p"+i+" = new ProfessorFunc();");
			System.out.println("p"+i+".setNome(\"Professor "+i+"\");");
			System.out.println("p"+i+".setDataNascimento(Calendar.getInstance());");
			System.out.println("p"+i+".setEmail(\"f"+i+"@gmail.com\");");
			System.out.println("p"+i+".setCpf(\"33342523501\");");
			System.out.println("p"+i+".setIsProfessor(true);");
			System.out.println("p"+i+".setSenha(\"123\");");
			System.out.println("p"+i+".setRg(\"22233344401\");");
			System.out.println("funcDAO.insert(p"+i+");");
		}
	}
}
