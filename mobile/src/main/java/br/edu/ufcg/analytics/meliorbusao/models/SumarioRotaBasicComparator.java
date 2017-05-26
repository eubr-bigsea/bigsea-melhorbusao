package br.edu.ufcg.analytics.meliorbusao.models;

import java.util.Comparator;

public class SumarioRotaBasicComparator implements Comparator<RouteSummaryCard> {

    /**
     * Compara as rotas pela avaliação geral
     * @param sumarioRota1
     * @param sumarioRota2
     * @return
     */
    @Override
    public int compare(RouteSummaryCard sumarioRota1, RouteSummaryCard sumarioRota2) {
        if (sumarioRota1.getRouteSummary().getSumarioGeral() > sumarioRota2.getRouteSummary().getSumarioGeral()) {
            return -1;
        }
        if (sumarioRota1.getRouteSummary().getSumarioGeral() < sumarioRota2.getRouteSummary().getSumarioGeral()) {
            return 1;
        }
        return 0;
    }
}