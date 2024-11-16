import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula dir, esq, sup, inf;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.dir = this.esq = this.sup = this.inf = null;
    }
}

class Matriz {
    private Celula inicio;
    private int linhas, colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;

        // Construir a matriz com ligações
        inicio = new Celula(0);
        Celula linhaAnterior = null, atual = inicio;

        for (int i = 0; i < linhas; i++) {
            Celula linhaAtual = (i > 0) ? new Celula(0) : inicio;
            if (linhaAnterior != null) {
                linhaAnterior.inf = linhaAtual;
                linhaAtual.sup = linhaAnterior;
            }

            Celula celulaAnterior = linhaAtual;
            for (int j = 1; j < colunas; j++) {
                Celula novaCelula = new Celula(0);
                celulaAnterior.dir = novaCelula;
                novaCelula.esq = celulaAnterior;

                if (linhaAnterior != null) {
                    linhaAnterior = linhaAnterior.dir;
                    linhaAnterior.inf = novaCelula;
                    novaCelula.sup = linhaAnterior;
                }

                celulaAnterior = novaCelula;
            }
            linhaAnterior = linhaAtual;
        }
    }

    public void printar() {
        Celula linhaAtual = inicio;
        while (linhaAtual != null) {
            Celula celulaAtual = linhaAtual;
            while (celulaAtual != null) {
                System.out.print(celulaAtual.elemento + " ");
                celulaAtual = celulaAtual.dir;
            }
            System.out.println();
            linhaAtual = linhaAtual.inf;
        }
    }

    public void diagPrincipal() {
        Celula atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = (atual.inf != null) ? atual.inf.dir : null;
        }
        System.out.println();
    }

    public void diagSecundaria() {
        Celula atual = inicio;
        while (atual.dir != null) {
            atual = atual.dir;
        }

        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = (atual.inf != null) ? atual.inf.esq : null;
        }
        System.out.println();
    }

    public void preencher(Scanner sc) {
        Celula linhaAtual = inicio;
        for (int i = 0; i < linhas; i++) {
            Celula celulaAtual = linhaAtual;
            for (int j = 0; j < colunas; j++) {
                celulaAtual.elemento = sc.nextInt();
                celulaAtual = celulaAtual.dir;
            }
            linhaAtual = linhaAtual.inf;
        }
    }

    public Matriz somaDuasMatriz(Matriz b) {
        if (this.linhas != b.linhas || this.colunas != b.colunas) {
            throw new IllegalArgumentException("As matrizes devem ter dimensões iguais para soma.");
        }

        Matriz resultado = new Matriz(this.linhas, this.colunas);
        Celula resAtual = resultado.inicio, aAtual = this.inicio, bAtual = b.inicio;

        for (int i = 0; i < linhas; i++) {
            Celula resLinha = resAtual, aLinha = aAtual, bLinha = bAtual;
            for (int j = 0; j < colunas; j++) {
                resLinha.elemento = aLinha.elemento + bLinha.elemento;
                resLinha = resLinha.dir;
                aLinha = aLinha.dir;
                bLinha = bLinha.dir;
            }
            resAtual = resAtual.inf;
            aAtual = aAtual.inf;
            bAtual = bAtual.inf;
        }
        return resultado;
    }

    public Matriz multiplicaDuasMatriz(Matriz b) {
        if (this.colunas != b.linhas) {
            throw new IllegalArgumentException("As matrizes não podem ser multiplicadas.");
        }

        Matriz resultado = new Matriz(this.linhas, b.colunas);
        Celula resAtual = resultado.inicio, aAtual = this.inicio;

        for (int i = 0; i < linhas; i++) {
            Celula bLinhaInicial = b.inicio;
            for (int j = 0; j < b.colunas; j++) {
                Celula auxA = aAtual, auxB = bLinhaInicial;
                int soma = 0;

                for (int k = 0; k < colunas; k++) {
                    soma += auxA.elemento * auxB.elemento;
                    auxA = auxA.dir;
                    auxB = auxB.inf;
                }

                resAtual.elemento = soma;
                resAtual = resAtual.dir;
                bLinhaInicial = bLinhaInicial.dir;
            }
            aAtual = aAtual.inf;
            resAtual = resultado.inicio;
            for (int k = 0; k <= i; k++) {
                resAtual = resAtual.inf;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();

        for (int t = 0; t < testes; t++) {
            int linhas1 = sc.nextInt();
            int colunas1 = sc.nextInt();
            Matriz matriz1 = new Matriz(linhas1, colunas1);
            matriz1.preencher(sc);

            int linhas2 = sc.nextInt();
            int colunas2 = sc.nextInt();
            Matriz matriz2 = new Matriz(linhas2, colunas2);
            matriz2.preencher(sc);

            matriz1.diagPrincipal();
            matriz1.diagSecundaria();

            Matriz soma = matriz1.somaDuasMatriz(matriz2);
            soma.printar();

            if (colunas1 == linhas2) {
                Matriz multiplicacao = matriz1.multiplicaDuasMatriz(matriz2);
                multiplicacao.printar();
            }
        }

        sc.close();
    }
}
