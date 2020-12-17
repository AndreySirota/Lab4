package bsu.rfe.java.group8.Lab4.Sirota.Var1A;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.*;

public class GraphicsDisplay extends JPanel {
    private Double [][] graphicsData;
    // Флаговые переменные, задающие правила отображения графика
    private boolean showAxis = true;
    private boolean showMarkers = true;
    // Границы диапазона пространства, подлежащего отображению
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    // Используемый масштаб отображения
    private double scale;
    // Различные стили черчения линий
    private BasicStroke graphicsStroke;
    private BasicStroke axisStroke;
    private BasicStroke markerStroke;
    // Различные шрифты отображения надписей
    private Font axisFont;

    public GraphicsDisplay(){
        setBackground(Color.WHITE);
        // Сконструировать необходимые объекты, используемые в рисовании Перо для рисования графика
        graphicsStroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{40, 10, 10, 10, 10, 10, 20, 10,20}, 0.0f);
        // Перо для рисования осей координат
        axisStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        // Перо для рисования контуров маркеров
        markerStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 90.0f, null, 0.0f);
        // Шрифт для подписей осей координат
        axisFont = new Font("Serif", Font.BOLD, 35);
    }
    // Данный метод вызывается из обработчика элемента меню "Открыть файл с графиком"
    // главного окна приложения в случае успешной загрузки данных
    public void showGraphics(Double[][] graphicsData){
        // Сохранить массив точек во внутреннем поле класса
        this.graphicsData = graphicsData;
        // Запросить перерисовку компонента, т.е. неявно вызвать paintComponent()
        repaint();
    }
    // Методы-модификаторы для изменения параметров отображения графика
    // Изменение любого параметра приводит к перерисовке области
    public void setShowAxis(boolean showAxis){
        this.showAxis = showAxis;
        repaint();
    }
    public void setShowMarkers(boolean showMarkers){
        this.showMarkers = showMarkers;
        repaint();
    }