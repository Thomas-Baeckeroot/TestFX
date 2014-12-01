/*
 * Copyright 2013-2014 SmartBear Software
 *
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by the European
 * Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work
 * except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the Licence for the specific language governing permissions
 * and limitations under the Licence.
 */
package org.loadui.testfx.utils;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.loadui.testfx.utils.BoundsUtils.atPosition;
import static org.loadui.testfx.utils.BoundsUtils.atPositionFactors;
import static org.loadui.testfx.utils.BoundsUtils.computePositionFactors;

public class BoundsUtilsTest {

    //---------------------------------------------------------------------------------------------
    // FEATURE METHODS.
    //---------------------------------------------------------------------------------------------

    @Test
    public void atPosition_with_positions() {
        // given:
        BoundingBox bounds = new BoundingBox(100, 1000, 200, 2000);

        // expect:
        assertThat(atPosition(bounds, Pos.TOP_LEFT),      is(new Point2D(100, 1000)));
        assertThat(atPosition(bounds, Pos.TOP_CENTER),    is(new Point2D(200, 1000)));
        assertThat(atPosition(bounds, Pos.TOP_RIGHT),     is(new Point2D(300, 1000)));
        assertThat(atPosition(bounds, Pos.CENTER_LEFT),   is(new Point2D(100, 2000)));
        assertThat(atPosition(bounds, Pos.CENTER),        is(new Point2D(200, 2000)));
        assertThat(atPosition(bounds, Pos.CENTER_RIGHT),  is(new Point2D(300, 2000)));
        assertThat(atPosition(bounds, Pos.BOTTOM_LEFT),   is(new Point2D(100, 3000)));
        assertThat(atPosition(bounds, Pos.BOTTOM_CENTER), is(new Point2D(200, 3000)));
        assertThat(atPosition(bounds, Pos.BOTTOM_RIGHT),  is(new Point2D(300, 3000)));
    }

    @Test
    public void atPositionFactors_with_positionFactors() {
        // given:
        BoundingBox bounds = new BoundingBox(100, 1000, 200, 2000);

        // expect:
        assertThat(atPositionFactors(bounds, new Point2D(0.0, 0.0)), is(new Point2D(100, 1000)));
        assertThat(atPositionFactors(bounds, new Point2D(0.5, 0.0)), is(new Point2D(200, 1000)));
        assertThat(atPositionFactors(bounds, new Point2D(1.0, 0.0)), is(new Point2D(300, 1000)));
        assertThat(atPositionFactors(bounds, new Point2D(0.0, 0.5)), is(new Point2D(100, 2000)));
        assertThat(atPositionFactors(bounds, new Point2D(0.5, 0.5)), is(new Point2D(200, 2000)));
        assertThat(atPositionFactors(bounds, new Point2D(1.0, 0.5)), is(new Point2D(300, 2000)));
        assertThat(atPositionFactors(bounds, new Point2D(0.0, 1.0)), is(new Point2D(100, 3000)));
        assertThat(atPositionFactors(bounds, new Point2D(0.5, 1.0)), is(new Point2D(200, 3000)));
        assertThat(atPositionFactors(bounds, new Point2D(1.0, 1.0)), is(new Point2D(300, 3000)));
    }

    @Test
    public void computePositionFactors_with_positions() {
        // expect:
        assertThat(computePositionFactors(Pos.TOP_LEFT),      is(new Point2D(0.0, 0.0)));
        assertThat(computePositionFactors(Pos.TOP_CENTER),    is(new Point2D(0.5, 0.0)));
        assertThat(computePositionFactors(Pos.TOP_RIGHT),     is(new Point2D(1.0, 0.0)));
        assertThat(computePositionFactors(Pos.CENTER_LEFT),   is(new Point2D(0.0, 0.5)));
        assertThat(computePositionFactors(Pos.CENTER),        is(new Point2D(0.5, 0.5)));
        assertThat(computePositionFactors(Pos.CENTER_RIGHT),  is(new Point2D(1.0, 0.5)));
        assertThat(computePositionFactors(Pos.BOTTOM_LEFT),   is(new Point2D(0.0, 1.0)));
        assertThat(computePositionFactors(Pos.BOTTOM_CENTER), is(new Point2D(0.5, 1.0)));
        assertThat(computePositionFactors(Pos.BOTTOM_RIGHT),  is(new Point2D(1.0, 1.0)));
    }

}
