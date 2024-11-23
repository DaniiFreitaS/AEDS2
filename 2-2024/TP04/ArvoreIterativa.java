class No {
    public int elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(int elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
public class ArvoreIterativa {
    private No raiz; // Raiz da arvore.
    
    /**
     * Metodo iterativo para pesquisa na arvore
     * @param x Elemento a ser pesquisado
     */
    public boolean pesquisaI(int x){
		return pesquisaI(x, raiz);
	}

	private boolean pesquisaI(int x, No i){
		boolean resp = false;
		while (i != null && resp == false) {
			if(x < i.elemento){
				i = i.esq;
			}else if(x > i.elemento){
				i = i.dir;
			}else{
				resp = true;
			}
		}
		return resp;
	}

    /**
     * Metodo iterativo para inserir na arvore
     * @param x Elemento a ser inserido
     */
    public void inserirI(int x) throws Exception{
		if(raiz == null){
			raiz = new No(x);
		}else{
			No i = raiz;
			No pai = null;
			while (i != null) {
				pai = i;
				if(x < i.elemento){
					i = i.esq;
				}else if(x > i.elemento){
					i = i.dir;
				}else{
					throw new Exception("Erro ao inserir");
				}
			}
			if(x < pai.elemento){
				pai.esq = new No(x);
			}else{
				pai.dir = new No(x);
			}
		}
	}


}
