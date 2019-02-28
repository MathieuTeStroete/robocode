/**
 * Copyright (c) 2001-2017 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */
package nl.saxion;
import robocode.Robot;;import static robocode.util.Utils.normalRelativeAngleDegrees;


public class Tank1 extends Robot {

    private boolean left;
    private boolean top;

    private double destinationX;
    private double destinationY;

    private boolean topLeft;
    private boolean bottomLeft;
    private boolean topRight;
    private boolean bottomRight;


    public void run()
    {
        initialize();

        while(true)
        {

        moveToCorner();

        }
    }

    private void initialize()
    {
        if (this.getX() <= getBattleFieldWidth() / 2){left = true; }
        else left = false;

        if (this.getY() <= getBattleFieldHeight() / 2) {top = true;}
        else top = false;

        if (top && left)
        {
            destinationX = 0;
            destinationY = getBattleFieldHeight();;
        }
        else if (!top && left)
        {
            destinationX = 0;
            destinationY = 0;
        }
        else if (top && !left)
        {
            destinationX = getBattleFieldWidth();
            destinationY = getBattleFieldHeight();
        }
        else
        {
            destinationX = getBattleFieldWidth();
            destinationY = 0;
        }
    }

    private void moveToCorner()
    {
        double _startPositionX = this.getX();
        double _startPositionY = this.getY();

        double lengthX = Math.abs(destinationX - _startPositionX);
        double lengthY = Math.abs(destinationY - _startPositionY);

        double _travelDistance = Math.sqrt((lengthX * lengthX)+(lengthY*lengthY));

        double _degreesToTarget = Math.atan2(lengthY,lengthX);



        System.out.println(_degreesToTarget);

        //turnLeft(toTurnDegrees);
        ahead(_travelDistance);

        //rotate and move forwards to destination, forwards can be calculated with pythagoras.
        //Once he has moved this much forward decide to find new corner and repeat process.
    }

}
