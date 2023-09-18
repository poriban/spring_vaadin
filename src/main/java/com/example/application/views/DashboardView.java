package com.example.application.views;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;

/**
 * Dashboard View
 */
@PermitAll
@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin CRM")
public class DashboardView extends VerticalLayout {

    // メンバー変数
    private final CrmService service;

    // ページ表示
    public DashboardView(CrmService service) {
        this.service = service;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(getContactStats(), getCompaniesChart());
    }

    // 従業員数取得
    private Component getContactStats() {
        Span stats = new Span(service.countContacts() + " contacts");
        stats.addClassNames(
            LumoUtility.FontSize.XLARGE,
            LumoUtility.Margin.Top.MEDIUM);
        return stats;
    }

    // チャート図 会社別表示
    private Chart getCompaniesChart() {
        Chart chart = new Chart(ChartType.PIE);

        DataSeries dataSeries = new DataSeries();
        service.findAllCompanies().forEach(company ->
            dataSeries.add(new DataSeriesItem(company.getName(), company.getEmployeeCount())));
        chart.getConfiguration().setSeries(dataSeries);
        return chart;
    }
}