// Nome: Wender Abner Otoni de Souza - RA: 32512671

import java.util.Scanner;

public class MonitoramentoJumentos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        int abatesAnuais = 50000;

        System.out.println("=== S.O.S. JUMENTO NORDESTINO - SISTEMA DE MONITORAMENTO ===");
        System.out.println("População inicial de referência: " + populacaoInicial);
        System.out.println("População atual estimada: " + populacaoAtual);
        System.out.println("Abates anuais (simulados): " + abatesAnuais);
        System.out.println();

        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("[Análise Inicial] Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

        boolean risco = estaEmRiscoCritico(taxaReducao);

        if (risco) {
            System.out.println("[Status] Espécie em Risco CRÍTICO (Redução > 90%)!");
        } else {
            System.out.println("[Status] Espécie em risco moderado.");
        }

        System.out.println();
        System.out.print("Quantos anos futuros você deseja simular o impacto dos abates (Ex: 1, 3, 5)? ");
        int anosSimulados = sc.nextInt();
        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        System.out.println();
        System.out.println("--- RESULTADO DA SIMULAÇÃO ---");
        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);
        System.out.println();
        System.out.println("Programa de Monitoramento Finalizado.");

        sc.close();
    }

    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        double taxa = (1 - (double) populacaoAtual / populacaoInicial) * 100;
        return taxa;
    }

    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90;
    }

    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        int populacaoRestante = populacaoAtual - (abatesAnuais * anosSimulados);
        return populacaoRestante;
    }

    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        if (populacaoRestante <= 0) {
            System.out.println("População restante após " + anos + " anos: 0 jumentos.");
            System.out.println("🚨 Os jumentos entrariam em EXTINÇÃO TOTAL!");
        } else {
            System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");
            System.out.println();
            System.out.println("Ainda há esperança! Iniciativas de conservação são vitais.");
        }
    }
}
