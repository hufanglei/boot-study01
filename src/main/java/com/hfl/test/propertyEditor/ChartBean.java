package com.hfl.test.propertyEditor;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

/**
 * Created by hfl on 2017-5-23.
 */
public class ChartBean  extends JPanel{

    private int titlePosition = CENTER;
    private boolean inverse;

    public int getTitlePosition() {
        return titlePosition;
    }

    public void setTitlePosition(int titlePosition) {
        this.titlePosition = titlePosition;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }
}
