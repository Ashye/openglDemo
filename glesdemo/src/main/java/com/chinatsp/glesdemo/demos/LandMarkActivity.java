package com.chinatsp.glesdemo.demos;

import android.graphics.Point;
import android.opengl.GLU;
import android.util.Log;

import com.chinatsp.glesdemo.demos.Model.LandMark;
import com.chinatsp.glesdemo.demos.Model.Routine;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public class LandMarkActivity extends OpenGLESActivity {

    //经纬度
    private Vector<double[]> path = new Vector<>();

    {

        /**
         * 平面路径：下下下右右上上上上上上上左左左左左左左
         */
        path.add(new double[] {113.95398, 22.53655});
        path.add(new double[] {113.95399, 22.5364});
        path.add(new double[] {113.95399, 22.5364});
        path.add(new double[] {113.95399, 22.53632});
        path.add(new double[] {113.95399, 22.53632});
        path.add(new double[] {113.95403, 22.53631});
        path.add(new double[] {113.95403, 22.53631});
        path.add(new double[] {113.95403, 22.5364});
        path.add(new double[] {113.95403, 22.5364});
        path.add(new double[] {113.95402, 22.53665});
        path.add(new double[] {113.95402, 22.53665});
        path.add(new double[] {113.95401, 22.53684});
        path.add(new double[] {113.95401, 22.53684});
        path.add(new double[] {113.954, 22.53713});
        path.add(new double[] {113.954, 22.53713});
        path.add(new double[] {113.954, 22.53721});
        path.add(new double[] {113.954, 22.53721});
        path.add(new double[] {113.95399, 22.53752});
        path.add(new double[] {113.95399, 22.53752});
        path.add(new double[] {113.95398, 22.53776});
        path.add(new double[] {113.95398, 22.53776});
        path.add(new double[] {113.95398, 22.53829});
        path.add(new double[] {113.95398, 22.53829});
        path.add(new double[] {113.95397, 22.53888});
        path.add(new double[] {113.95397, 22.53888});
        path.add(new double[] {113.95395, 22.53895});
        path.add(new double[] {113.95395, 22.53895});
        path.add(new double[] {113.95396, 22.5392});
        path.add(new double[] {113.95396, 22.5392});
        path.add(new double[] {113.95396, 22.53938});
        path.add(new double[] {113.95396, 22.53938});
        path.add(new double[] {113.95395, 22.53965});
        path.add(new double[] {113.95395, 22.53965});
        path.add(new double[] {113.95394, 22.53987});
        path.add(new double[] {113.95394, 22.53987});
        path.add(new double[] {113.95393, 22.54012});
        path.add(new double[] {113.95393, 22.54012});
        path.add(new double[] {113.95394, 22.54038});
        path.add(new double[] {113.95394, 22.54038});
        path.add(new double[] {113.95386, 22.54038});
        path.add(new double[] {113.95386, 22.54038});
        path.add(new double[] {113.95357, 22.54036});
        path.add(new double[] {113.95357, 22.54036});
        path.add(new double[] {113.95329, 22.54035});
        path.add(new double[] {113.95329, 22.54035});
        path.add(new double[] {113.95295, 22.54034});
        path.add(new double[] {113.95295, 22.54034});
        path.add(new double[] {113.95225, 22.54031});
        path.add(new double[] {113.95225, 22.54031});
        path.add(new double[] {113.95198, 22.5403});
        path.add(new double[] {113.95198, 22.5403});
        path.add(new double[] {113.95171, 22.54028});
        path.add(new double[] {113.95171, 22.54028});
        path.add(new double[] {113.95131, 22.54026});
        path.add(new double[] {113.95131, 22.54026});
        path.add(new double[] {113.94914, 22.54016});
        path.add(new double[] {113.94914, 22.54016});
        path.add(new double[] {113.94805, 22.54012});
        path.add(new double[] {113.94805, 22.54012});
        path.add(new double[] {113.94786, 22.54009});
        path.add(new double[] {113.94786, 22.54009});
        path.add(new double[] {113.94742, 22.54008});
        path.add(new double[] {113.94742, 22.54008});
        path.add(new double[] {113.94695, 22.54006});
        path.add(new double[] {113.94695, 22.54006});
        path.add(new double[] {113.9463, 22.54003});
        path.add(new double[] {113.9463, 22.54003});
        path.add(new double[] {113.94578, 22.54001});
        path.add(new double[] {113.94578, 22.54001});
        path.add(new double[] {113.94552, 22.54});
        path.add(new double[] {113.94552, 22.54});
        path.add(new double[] {113.94532, 22.53999});
        path.add(new double[] {113.94532, 22.53999});
        path.add(new double[] {113.94465, 22.53995});
        path.add(new double[] {113.94465, 22.53995});
        path.add(new double[] {113.94331, 22.53989});
        path.add(new double[] {113.94331, 22.53989});
        path.add(new double[] {113.94285, 22.53996});


        /**
         * 平面路径：右右上上左左上左（右上）左左（右上）（右顺时圈）左左左左
         */
//        path.add(new double[] {113.95585, 22.53957});
//        path.add(new double[] {113.9552, 22.53957});
//        path.add(new double[] {113.95514, 22.53954});
//        path.add(new double[] {113.95514, 22.53921});
//        path.add(new double[] {113.95522, 22.53914});
//        path.add(new double[] {113.9554, 22.53916});
//        path.add(new double[] {113.9554, 22.53916});
//        path.add(new double[] {113.95589, 22.53916});
//        path.add(new double[] {113.95589, 22.53916});
//        path.add(new double[] {113.95594, 22.53898});
//        path.add(new double[] {113.95594, 22.53898});
//        path.add(new double[] {113.95593, 22.53894});
//        path.add(new double[] {113.95593, 22.53894});
//        path.add(new double[] {113.95604, 22.53894});
//        path.add(new double[] {113.95604, 22.53894});
//        path.add(new double[] {113.95627, 22.53891});
//        path.add(new double[] {113.95627, 22.53891});
//        path.add(new double[] {113.95638, 22.53885});
//        path.add(new double[] {113.95638, 22.53885});
//        path.add(new double[] {113.95657, 22.53867});
//        path.add(new double[] {113.95657, 22.53867});
//        path.add(new double[] {113.95664, 22.53858});
//        path.add(new double[] {113.95664, 22.53858});
//        path.add(new double[] {113.9568, 22.53836});
//        path.add(new double[] {113.9568, 22.53836});
//        path.add(new double[] {113.95696, 22.53814});
//        path.add(new double[] {113.95696, 22.53814});
//        path.add(new double[] {113.95699, 22.53804});
//        path.add(new double[] {113.95698, 22.53794});
//        path.add(new double[] {113.95698, 22.53794});
//        path.add(new double[] {113.9569, 22.53776});
//        path.add(new double[] {113.9569, 22.53776});
//        path.add(new double[] {113.95686, 22.53769});
//        path.add(new double[] {113.95686, 22.53769});
//        path.add(new double[] {113.95682, 22.53764});
//        path.add(new double[] {113.95682, 22.53764});
//        path.add(new double[] {113.95673, 22.53748});
//        path.add(new double[] {113.95673, 22.53748});
//        path.add(new double[] {113.95665, 22.53734});
//        path.add(new double[] {113.95665, 22.53734});
//        path.add(new double[] {113.95642, 22.53698});
//        path.add(new double[] {113.95642, 22.53698});
//        path.add(new double[] {113.95639, 22.53692});
//        path.add(new double[] {113.95639, 22.53692});
//        path.add(new double[] {113.95618, 22.53656});
//        path.add(new double[] {113.95618, 22.53656});
//        path.add(new double[] {113.95616, 22.53653});
//        path.add(new double[] {113.95616, 22.53653});
//        path.add(new double[] {113.956, 22.53628});
//        path.add(new double[] {113.956, 22.53628});
//        path.add(new double[] {113.95563, 22.53569});
//        path.add(new double[] {113.95563, 22.53569});
//        path.add(new double[] {113.95559, 22.5356});
//        path.add(new double[] {113.95559, 22.5356});
//        path.add(new double[] {113.95559, 22.53552});
//        path.add(new double[] {113.95559, 22.53552});
//        path.add(new double[] {113.95643, 22.53511});
//        path.add(new double[] {113.95643, 22.53511});
//        path.add(new double[] {113.95656, 22.53492});
//        path.add(new double[] {113.95656, 22.53473});
//        path.add(new double[] {113.95656, 22.53473});
//        path.add(new double[] {113.95636, 22.53443});
//        path.add(new double[] {113.95636, 22.53443});
//        path.add(new double[] {113.95628, 22.5343});
//        path.add(new double[] {113.95628, 22.5343});
//        path.add(new double[] {113.95537, 22.53281});
//        path.add(new double[] {113.95509, 22.53217});
//        path.add(new double[] {113.95491, 22.53157});
//        path.add(new double[] {113.95491, 22.53157});
//        path.add(new double[] {113.95488, 22.53091});
//        path.add(new double[] {113.95488, 22.53091});
//        path.add(new double[] {113.95474, 22.52854});
//        path.add(new double[] {113.95474, 22.52854});
//        path.add(new double[] {113.95473, 22.52832});
//        path.add(new double[] {113.95473, 22.52832});
//        path.add(new double[] {113.95469, 22.52788});
//        path.add(new double[] {113.95469, 22.52788});
//        path.add(new double[] {113.95465, 22.52719});
//        path.add(new double[] {113.95465, 22.52719});
//        path.add(new double[] {113.95465, 22.52711});
//        path.add(new double[] {113.95465, 22.52711});
//        path.add(new double[] {113.95461, 22.52674});
//        path.add(new double[] {113.95461, 22.52674});
//        path.add(new double[] {113.95454, 22.52608});
//        path.add(new double[] {113.95454, 22.52608});
//        path.add(new double[] {113.95452, 22.52587});
//        path.add(new double[] {113.95452, 22.52587});
//        path.add(new double[] {113.95436, 22.5247});
//        path.add(new double[] {113.95431, 22.52408});
//        path.add(new double[] {113.95431, 22.52408});
//        path.add(new double[] {113.95429, 22.52398});
//        path.add(new double[] {113.95429, 22.52398});
//        path.add(new double[] {113.954, 22.52162});
//        path.add(new double[] {113.954, 22.52162});
//        path.add(new double[] {113.9539, 22.52095});
//        path.add(new double[] {113.9539, 22.52095});
//        path.add(new double[] {113.95383, 22.5203});
//        path.add(new double[] {113.95383, 22.5203});
//        path.add(new double[] {113.9536, 22.51968});
//        path.add(new double[] {113.95354, 22.51959});
//        path.add(new double[] {113.95336, 22.51945});
//        path.add(new double[] {113.95317, 22.51939});
//        path.add(new double[] {113.95301, 22.51938});
//        path.add(new double[] {113.95268, 22.51949});
//        path.add(new double[] {113.95256, 22.51965});
//        path.add(new double[] {113.95247, 22.51989});
//        path.add(new double[] {113.95247, 22.52012});
//        path.add(new double[] {113.95254, 22.52033});
//        path.add(new double[] {113.95268, 22.52048});
//        path.add(new double[] {113.95286, 22.52057});
//        path.add(new double[] {113.95299, 22.52061});
//        path.add(new double[] {113.9533, 22.52064});
//        path.add(new double[] {113.9533, 22.52064});
//        path.add(new double[] {113.95413, 22.52057});
//        path.add(new double[] {113.95413, 22.52057});
//        path.add(new double[] {113.95463, 22.52052});
//        path.add(new double[] {113.95463, 22.52052});
//        path.add(new double[] {113.95626, 22.52033});
//        path.add(new double[] {113.95626, 22.52033});
//        path.add(new double[] {113.95691, 22.52026});
//        path.add(new double[] {113.95691, 22.52026});
//        path.add(new double[] {113.95832, 22.5201});


//        //到宝安机场
//        path.add(new double[]{113.95362,22.53823});
//        path.add(new double[]{113.95377,22.53828});
//        path.add(new double[]{113.95377,22.53828});
//        path.add(new double[]{113.95394,22.53829});
//        path.add(new double[]{113.95394,22.53829});
//        path.add(new double[]{113.95395,22.53752});
//        path.add(new double[]{113.95395,22.53752});
//        path.add(new double[]{113.95396,22.53721});
//        path.add(new double[]{113.95396,22.53721});
//        path.add(new double[]{113.954,22.53721});
//        path.add(new double[]{113.954,22.53721});
//        path.add(new double[]{113.95399,22.53752});
//        path.add(new double[]{113.95399,22.53752});
//        path.add(new double[]{113.95398,22.53776});
//        path.add(new double[]{113.95398,22.53776});
//        path.add(new double[]{113.95398,22.53829});
//        path.add(new double[]{113.95398,22.53829});
//        path.add(new double[]{113.95397,22.53888});
//        path.add(new double[]{113.95397,22.53888});
//        path.add(new double[]{113.95395,22.53895});
//        path.add(new double[]{113.95395,22.53895});
//        path.add(new double[]{113.95396,22.5392});
//        path.add(new double[]{113.95396,22.5392});
//        path.add(new double[]{113.95396,22.53938});
//        path.add(new double[]{113.95396,22.53938});
//        path.add(new double[]{113.95395,22.53965});
//        path.add(new double[]{113.95395,22.53965});
//        path.add(new double[]{113.95394,22.53987});
//        path.add(new double[]{113.95394,22.53987});
//        path.add(new double[]{113.95393,22.54012});
//        path.add(new double[]{113.95393,22.54012});
//        path.add(new double[]{113.95394,22.54038});
//        path.add(new double[]{113.95394,22.54038});
//        path.add(new double[]{113.95386,22.54038});
//        path.add(new double[]{113.95386,22.54038});
//        path.add(new double[]{113.95357,22.54036});
//        path.add(new double[]{113.95357,22.54036});
//        path.add(new double[]{113.95329,22.54035});
//        path.add(new double[]{113.95329,22.54035});
//        path.add(new double[]{113.95295,22.54034});
//        path.add(new double[]{113.95295,22.54034});
//        path.add(new double[]{113.95225,22.54031});
//        path.add(new double[]{113.95225,22.54031});
//        path.add(new double[]{113.95198,22.5403});
//        path.add(new double[]{113.95198,22.5403});
//        path.add(new double[]{113.95171,22.54028});
//        path.add(new double[]{113.95171,22.54028});
//        path.add(new double[]{113.95131,22.54026});
//        path.add(new double[]{113.95131,22.54026});
//        path.add(new double[]{113.94914,22.54016});
//        path.add(new double[]{113.94914,22.54016});
//        path.add(new double[]{113.94805,22.54012});
//        path.add(new double[]{113.94805,22.54012});
//        path.add(new double[]{113.94786,22.54009});
//        path.add(new double[]{113.94786,22.54009});
//        path.add(new double[]{113.94742,22.54008});
//        path.add(new double[]{113.94742,22.54008});
//        path.add(new double[]{113.94695,22.54006});
//        path.add(new double[]{113.94695,22.54006});
//        path.add(new double[]{113.9463,22.54003});
//        path.add(new double[]{113.9463,22.54003});
//        path.add(new double[]{113.94578,22.54001});
//        path.add(new double[]{113.94578,22.54001});
//        path.add(new double[]{113.94552,22.54});
//        path.add(new double[]{113.94552,22.54});
//        path.add(new double[]{113.94532,22.53999});
//        path.add(new double[]{113.94532,22.53999});
//        path.add(new double[]{113.94465,22.53995});
//        path.add(new double[]{113.94465,22.53995});
//        path.add(new double[]{113.94331,22.53989});
//        path.add(new double[]{113.94331,22.53989});
//        path.add(new double[]{113.94292,22.53988});
//        path.add(new double[]{113.94292,22.53988});
//        path.add(new double[]{113.9417,22.53982});
//        path.add(new double[]{113.9417,22.53982});
//        path.add(new double[]{113.94114,22.53979});
//        path.add(new double[]{113.94114,22.53979});
//        path.add(new double[]{113.94052,22.53976});
//        path.add(new double[]{113.94052,22.53976});
//        path.add(new double[]{113.93915,22.5397});
//        path.add(new double[]{113.93915,22.5397});
//        path.add(new double[]{113.93794,22.53965});
//        path.add(new double[]{113.93794,22.53965});
//        path.add(new double[]{113.93674,22.53966});
//        path.add(new double[]{113.93674,22.53966});
//        path.add(new double[]{113.93608,22.53968});
//        path.add(new double[]{113.93608,22.53968});
//        path.add(new double[]{113.93569,22.53969});
//        path.add(new double[]{113.93569,22.53969});
//        path.add(new double[]{113.93521,22.53971});
//        path.add(new double[]{113.93521,22.53971});
//        path.add(new double[]{113.93491,22.53972});
//        path.add(new double[]{113.93491,22.53972});
//        path.add(new double[]{113.93446,22.53975});
//        path.add(new double[]{113.93446,22.53975});
//        path.add(new double[]{113.93402,22.53976});
//        path.add(new double[]{113.93402,22.53976});
//        path.add(new double[]{113.93127,22.5399});
//        path.add(new double[]{113.93127,22.5399});
//        path.add(new double[]{113.93035,22.53992});
//        path.add(new double[]{113.93035,22.53992});
//        path.add(new double[]{113.9293,22.53993});
//        path.add(new double[]{113.9293,22.53993});
//        path.add(new double[]{113.92816,22.53999});
//        path.add(new double[]{113.92816,22.53999});
//        path.add(new double[]{113.9281,22.53999});
//        path.add(new double[]{113.9281,22.53999});
//        path.add(new double[]{113.92806,22.53999});
//        path.add(new double[]{113.92806,22.53999});
//        path.add(new double[]{113.92774,22.54001});
//        path.add(new double[]{113.92774,22.54001});
//        path.add(new double[]{113.92752,22.54002});
//        path.add(new double[]{113.92752,22.54002});
//        path.add(new double[]{113.92749,22.54003});
//        path.add(new double[]{113.92749,22.54003});
//        path.add(new double[]{113.92689,22.54007});
//        path.add(new double[]{113.92689,22.54007});
//        path.add(new double[]{113.92632,22.5401});
//        path.add(new double[]{113.92632,22.5401});
//        path.add(new double[]{113.92617,22.54009});
//        path.add(new double[]{113.92617,22.54009});
//        path.add(new double[]{113.9259,22.5401});
//        path.add(new double[]{113.9259,22.5401});
//        path.add(new double[]{113.92566,22.54011});
//        path.add(new double[]{113.92566,22.54011});
//        path.add(new double[]{113.92539,22.54013});
//        path.add(new double[]{113.92539,22.54013});
//        path.add(new double[]{113.92496,22.54016});
//        path.add(new double[]{113.92496,22.54016});
//        path.add(new double[]{113.92481,22.54017});
//        path.add(new double[]{113.92481,22.54017});
//        path.add(new double[]{113.92458,22.54018});
//        path.add(new double[]{113.92458,22.54018});
//        path.add(new double[]{113.92397,22.54021});
//        path.add(new double[]{113.92397,22.54021});
//        path.add(new double[]{113.92385,22.54021});
//        path.add(new double[]{113.92385,22.54021});
//        path.add(new double[]{113.92358,22.54021});
//        path.add(new double[]{113.92358,22.54021});
//        path.add(new double[]{113.92343,22.54021});
//        path.add(new double[]{113.92343,22.54021});
//        path.add(new double[]{113.92331,22.54021});
//        path.add(new double[]{113.92331,22.54021});
//        path.add(new double[]{113.92256,22.54023});
//        path.add(new double[]{113.92256,22.54023});
//        path.add(new double[]{113.92093,22.54031});
//        path.add(new double[]{113.92041,22.54038});
//        path.add(new double[]{113.92041,22.54038});
//        path.add(new double[]{113.92034,22.5404});
//        path.add(new double[]{113.92034,22.5404});
//        path.add(new double[]{113.91944,22.54069});
//        path.add(new double[]{113.91944,22.54069});
//        path.add(new double[]{113.91893,22.54084});
//        path.add(new double[]{113.91893,22.54084});
//        path.add(new double[]{113.91856,22.54095});
//        path.add(new double[]{113.91856,22.54095});
//        path.add(new double[]{113.91816,22.5411});
//        path.add(new double[]{113.91816,22.5411});
//        path.add(new double[]{113.91748,22.54145});
//        path.add(new double[]{113.91748,22.54145});
//        path.add(new double[]{113.91693,22.54182});
//        path.add(new double[]{113.91693,22.54182});
//        path.add(new double[]{113.91676,22.54194});
//        path.add(new double[]{113.91623,22.54243});
//        path.add(new double[]{113.91623,22.54243});
//        path.add(new double[]{113.91574,22.54306});
//        path.add(new double[]{113.91574,22.54306});
//        path.add(new double[]{113.91554,22.54337});
//        path.add(new double[]{113.91554,22.54337});
//        path.add(new double[]{113.91539,22.54369});
//        path.add(new double[]{113.91539,22.54369});
//        path.add(new double[]{113.91517,22.54413});
//        path.add(new double[]{113.91517,22.54413});
//        path.add(new double[]{113.91502,22.54443});
//        path.add(new double[]{113.91502,22.54443});
//        path.add(new double[]{113.91474,22.54504});
//        path.add(new double[]{113.91474,22.54504});
//        path.add(new double[]{113.91441,22.54568});
//        path.add(new double[]{113.91441,22.54568});
//        path.add(new double[]{113.91412,22.54615});
//        path.add(new double[]{113.91393,22.54655});
//        path.add(new double[]{113.91393,22.54655});
//        path.add(new double[]{113.91342,22.54761});
//        path.add(new double[]{113.91342,22.54761});
//        path.add(new double[]{113.91315,22.54805});
//        path.add(new double[]{113.91315,22.54805});
//        path.add(new double[]{113.91244,22.5492});
//        path.add(new double[]{113.91244,22.5492});
//        path.add(new double[]{113.91214,22.54965});
//        path.add(new double[]{113.91214,22.54965});
//        path.add(new double[]{113.91204,22.54982});
//        path.add(new double[]{113.91204,22.54982});
//        path.add(new double[]{113.91199,22.54991});
//        path.add(new double[]{113.91199,22.54991});
//        path.add(new double[]{113.91161,22.55063});
//        path.add(new double[]{113.91092,22.55172});
//        path.add(new double[]{113.90995,22.55289});
//        path.add(new double[]{113.90995,22.55289});
//        path.add(new double[]{113.90976,22.55313});
//        path.add(new double[]{113.90965,22.55333});
//        path.add(new double[]{113.90965,22.55333});
//        path.add(new double[]{113.90906,22.55402});
//        path.add(new double[]{113.90906,22.55402});
//        path.add(new double[]{113.90895,22.55416});
//        path.add(new double[]{113.90895,22.55416});
//        path.add(new double[]{113.90883,22.5543});
//        path.add(new double[]{113.90883,22.5543});
//        path.add(new double[]{113.90828,22.55488});
//        path.add(new double[]{113.90828,22.55488});
//        path.add(new double[]{113.90797,22.55519});
//        path.add(new double[]{113.90797,22.55519});
//        path.add(new double[]{113.90747,22.55568});
//        path.add(new double[]{113.90704,22.55603});
//        path.add(new double[]{113.90656,22.55636});
//        path.add(new double[]{113.90656,22.55636});
//        path.add(new double[]{113.90616,22.55667});
//        path.add(new double[]{113.90616,22.55667});
//        path.add(new double[]{113.90573,22.55699});
//        path.add(new double[]{113.90573,22.55699});
//        path.add(new double[]{113.90523,22.55736});
//        path.add(new double[]{113.90523,22.55736});
//        path.add(new double[]{113.90161,22.56011});
//        path.add(new double[]{113.90161,22.56011});
//        path.add(new double[]{113.90025,22.56121});
//        path.add(new double[]{113.90025,22.56121});
//        path.add(new double[]{113.89998,22.56146});
//        path.add(new double[]{113.89998,22.56146});
//        path.add(new double[]{113.89911,22.56235});
//        path.add(new double[]{113.89911,22.56235});
//        path.add(new double[]{113.89832,22.56318});
//        path.add(new double[]{113.89669,22.56505});
//        path.add(new double[]{113.89669,22.56505});
//        path.add(new double[]{113.89617,22.56562});
//        path.add(new double[]{113.89617,22.56562});
//        path.add(new double[]{113.89553,22.56628});
//        path.add(new double[]{113.89553,22.56628});
//        path.add(new double[]{113.89523,22.56658});
//        path.add(new double[]{113.89523,22.56658});
//        path.add(new double[]{113.89369,22.56815});
//        path.add(new double[]{113.89244,22.56935});
//        path.add(new double[]{113.89244,22.56935});
//        path.add(new double[]{113.8919,22.56986});
//        path.add(new double[]{113.8919,22.56986});
//        path.add(new double[]{113.88844,22.57301});
//        path.add(new double[]{113.88844,22.57301});
//        path.add(new double[]{113.8878,22.57359});
//        path.add(new double[]{113.8878,22.57359});
//        path.add(new double[]{113.8876,22.57375});
//        path.add(new double[]{113.8876,22.57375});
//        path.add(new double[]{113.88728,22.57402});
//        path.add(new double[]{113.88728,22.57402});
//        path.add(new double[]{113.8864,22.57483});
//        path.add(new double[]{113.8864,22.57483});
//        path.add(new double[]{113.886,22.57523});
//        path.add(new double[]{113.886,22.57523});
//        path.add(new double[]{113.88491,22.57626});
//        path.add(new double[]{113.88355,22.57764});
//        path.add(new double[]{113.88355,22.57764});
//        path.add(new double[]{113.88191,22.57929});
//        path.add(new double[]{113.88133,22.57993});
//        path.add(new double[]{113.88133,22.57993});
//        path.add(new double[]{113.87914,22.58235});
//        path.add(new double[]{113.87914,22.58235});
//        path.add(new double[]{113.87841,22.58316});
//        path.add(new double[]{113.87841,22.58316});
//        path.add(new double[]{113.87826,22.58333});
//        path.add(new double[]{113.87826,22.58333});
//        path.add(new double[]{113.87757,22.58411});
//        path.add(new double[]{113.87757,22.58411});
//        path.add(new double[]{113.87716,22.58456});
//        path.add(new double[]{113.87716,22.58456});
//        path.add(new double[]{113.87669,22.58509});
//        path.add(new double[]{113.87669,22.58509});
//        path.add(new double[]{113.87584,22.58603});
//        path.add(new double[]{113.87584,22.58603});
//        path.add(new double[]{113.87581,22.58606});
//        path.add(new double[]{113.87581,22.58606});
//        path.add(new double[]{113.87552,22.58638});
//        path.add(new double[]{113.87552,22.58638});
//        path.add(new double[]{113.8753,22.58665});
//        path.add(new double[]{113.8753,22.58665});
//        path.add(new double[]{113.87505,22.58699});
//        path.add(new double[]{113.87505,22.58699});
//        path.add(new double[]{113.875,22.58705});
//        path.add(new double[]{113.875,22.58705});
//        path.add(new double[]{113.87441,22.58801});
//        path.add(new double[]{113.87441,22.58801});
//        path.add(new double[]{113.87425,22.58829});
//        path.add(new double[]{113.87425,22.58829});
//        path.add(new double[]{113.87398,22.58879});
//        path.add(new double[]{113.87398,22.58879});
//        path.add(new double[]{113.87382,22.58908});
//        path.add(new double[]{113.87382,22.58908});
//        path.add(new double[]{113.87365,22.5894});
//        path.add(new double[]{113.87365,22.5894});
//        path.add(new double[]{113.87344,22.58981});
//        path.add(new double[]{113.87344,22.58981});
//        path.add(new double[]{113.87317,22.59025});
//        path.add(new double[]{113.87259,22.59134});
//        path.add(new double[]{113.87227,22.59186});
//        path.add(new double[]{113.87227,22.59186});
//        path.add(new double[]{113.87146,22.59323});
//        path.add(new double[]{113.86907,22.59687});
//        path.add(new double[]{113.86907,22.59687});
//        path.add(new double[]{113.86882,22.59725});
//        path.add(new double[]{113.86882,22.59725});
//        path.add(new double[]{113.8685,22.59774});
//        path.add(new double[]{113.8685,22.59774});
//        path.add(new double[]{113.86764,22.59901});
//        path.add(new double[]{113.86764,22.59901});
//        path.add(new double[]{113.86633,22.60105});
//        path.add(new double[]{113.86633,22.60105});
//        path.add(new double[]{113.866,22.60151});
//        path.add(new double[]{113.866,22.60151});
//        path.add(new double[]{113.86533,22.60235});
//        path.add(new double[]{113.86533,22.60235});
//        path.add(new double[]{113.86489,22.60284});
//        path.add(new double[]{113.86344,22.60427});
//        path.add(new double[]{113.86344,22.60427});
//        path.add(new double[]{113.8623,22.60544});
//        path.add(new double[]{113.86188,22.60591});
//        path.add(new double[]{113.86136,22.60662});
//        path.add(new double[]{113.86103,22.60713});
//        path.add(new double[]{113.86103,22.60713});
//        path.add(new double[]{113.86077,22.60758});
//        path.add(new double[]{113.86077,22.60758});
//        path.add(new double[]{113.85965,22.60985});
//        path.add(new double[]{113.85965,22.60985});
//        path.add(new double[]{113.85956,22.61002});
//        path.add(new double[]{113.85956,22.61002});
//        path.add(new double[]{113.8594,22.61041});
//        path.add(new double[]{113.8594,22.61041});
//        path.add(new double[]{113.85931,22.6106});
//        path.add(new double[]{113.85931,22.6106});
//        path.add(new double[]{113.85922,22.6108});
//        path.add(new double[]{113.85922,22.6108});
//        path.add(new double[]{113.8589,22.61144});
//        path.add(new double[]{113.8589,22.61144});
//        path.add(new double[]{113.8585,22.61227});
//        path.add(new double[]{113.8585,22.61227});
//        path.add(new double[]{113.85779,22.6136});
//        path.add(new double[]{113.85779,22.6136});
//        path.add(new double[]{113.85745,22.61417});
//        path.add(new double[]{113.85745,22.61417});
//        path.add(new double[]{113.85721,22.61454});
//        path.add(new double[]{113.85721,22.61454});
//        path.add(new double[]{113.85676,22.61525});
//        path.add(new double[]{113.85642,22.61572});
//        path.add(new double[]{113.85556,22.6168});
//        path.add(new double[]{113.85556,22.6168});
//        path.add(new double[]{113.85505,22.61739});
//        path.add(new double[]{113.85505,22.61739});
//        path.add(new double[]{113.85491,22.61755});
//        path.add(new double[]{113.85491,22.61755});
//        path.add(new double[]{113.85397,22.61862});
//        path.add(new double[]{113.85397,22.61862});
//        path.add(new double[]{113.85372,22.6191});
//        path.add(new double[]{113.85372,22.6191});
//        path.add(new double[]{113.85327,22.61968});
//        path.add(new double[]{113.85327,22.61968});
//        path.add(new double[]{113.85315,22.61982});
//        path.add(new double[]{113.85315,22.61982});
//        path.add(new double[]{113.85261,22.62046});
//        path.add(new double[]{113.85261,22.62046});
//        path.add(new double[]{113.85247,22.62064});
//        path.add(new double[]{113.85247,22.62064});
//        path.add(new double[]{113.85262,22.62073});
//        path.add(new double[]{113.85262,22.62073});
//        path.add(new double[]{113.85274,22.62081});
//        path.add(new double[]{113.85274,22.62081});
//        path.add(new double[]{113.85322,22.62111});
//        path.add(new double[]{113.85348,22.62123});
//        path.add(new double[]{113.85348,22.62123});
//        path.add(new double[]{113.85424,22.62161});
//        path.add(new double[]{113.85434,22.62169});
//        path.add(new double[]{113.85443,22.62186});
//        path.add(new double[]{113.85439,22.62231});
//        path.add(new double[]{113.85443,22.62235});
//        path.add(new double[]{113.85443,22.62235});
//        path.add(new double[]{113.8545,22.62235});
//        path.add(new double[]{113.85472,22.6221});
//        path.add(new double[]{113.85486,22.62204});
//        path.add(new double[]{113.85486,22.62204});
//        path.add(new double[]{113.8549,22.62191});
//        path.add(new double[]{113.8549,22.62191});
//        path.add(new double[]{113.85437,22.62141});
//        path.add(new double[]{113.85437,22.62141});
//        path.add(new double[]{113.85342,22.62069});
//        path.add(new double[]{113.85342,22.62069});
//        path.add(new double[]{113.85282,22.62029});
//        path.add(new double[]{113.85282,22.62029});
//        path.add(new double[]{113.85224,22.61998});
//        path.add(new double[]{113.85139,22.61964});
//        path.add(new double[]{113.84984,22.61922});
//        path.add(new double[]{113.84984,22.61922});
//        path.add(new double[]{113.84895,22.619});
//        path.add(new double[]{113.84895,22.619});
//        path.add(new double[]{113.8442,22.61776});
//        path.add(new double[]{113.8442,22.61776});
//        path.add(new double[]{113.84136,22.61701});
//        path.add(new double[]{113.8403,22.6167});
//        path.add(new double[]{113.83984,22.61655});
//        path.add(new double[]{113.83963,22.61645});
//        path.add(new double[]{113.83934,22.61638});
//        path.add(new double[]{113.83762,22.61565});
//        path.add(new double[]{113.83648,22.61511});
//        path.add(new double[]{113.83648,22.61511});
//        path.add(new double[]{113.83481,22.61431});
//        path.add(new double[]{113.83481,22.61431});
//        path.add(new double[]{113.83308,22.61348});
//        path.add(new double[]{113.83308,22.61348});
//        path.add(new double[]{113.8326,22.61325});
//        path.add(new double[]{113.8326,22.61325});
//        path.add(new double[]{113.8317,22.61282});
//        path.add(new double[]{113.8317,22.61282});
//        path.add(new double[]{113.82852,22.6113});
//        path.add(new double[]{113.82852,22.6113});
//        path.add(new double[]{113.82735,22.61077});
//        path.add(new double[]{113.82735,22.61077});
//        path.add(new double[]{113.82708,22.61064});
//        path.add(new double[]{113.82708,22.61064});
//        path.add(new double[]{113.82438,22.60938});
//        path.add(new double[]{113.82407,22.60927});
//        path.add(new double[]{113.82407,22.60927});
//        path.add(new double[]{113.82369,22.60919});
//        path.add(new double[]{113.82325,22.60917});
//        path.add(new double[]{113.82278,22.60929});
//        path.add(new double[]{113.8226,22.60938});
//        path.add(new double[]{113.82241,22.6095});
//        path.add(new double[]{113.82208,22.60983});
//        path.add(new double[]{113.82176,22.61031});
//        path.add(new double[]{113.82143,22.61092});
//        path.add(new double[]{113.82143,22.61092});
//        path.add(new double[]{113.82092,22.61185});
//        path.add(new double[]{113.82092,22.61185});
//        path.add(new double[]{113.82042,22.61278});
//        path.add(new double[]{113.82042,22.61278});
//        path.add(new double[]{113.81833,22.61671});
//        path.add(new double[]{113.81833,22.61671});
//        path.add(new double[]{113.81773,22.61781});
//        path.add(new double[]{113.81773,22.61781});
//        path.add(new double[]{113.8175,22.61821});
//        path.add(new double[]{113.8175,22.61821});
//        path.add(new double[]{113.81709,22.61899});
//        path.add(new double[]{113.81698,22.61953});
//        path.add(new double[]{113.817,22.61973});
//        path.add(new double[]{113.81717,22.62017});
//        path.add(new double[]{113.81753,22.62072});
//        path.add(new double[]{113.81753,22.62072});
//        path.add(new double[]{113.81786,22.6213});
//        path.add(new double[]{113.81786,22.6213});
//        path.add(new double[]{113.81799,22.62166});
//        path.add(new double[]{113.81804,22.62223});
//        path.add(new double[]{113.818,22.6226});
//        path.add(new double[]{113.81786,22.623});
//        path.add(new double[]{113.81774,22.62324});
//        path.add(new double[]{113.81774,22.62324});
//        path.add(new double[]{113.81756,22.62358});
//        path.add(new double[]{113.81756,22.62358});
//        path.add(new double[]{113.81705,22.62452});
//        path.add(new double[]{113.81676,22.62492});
//        path.add(new double[]{113.81644,22.62515});
//        path.add(new double[]{113.8163,22.62521});
//        path.add(new double[]{113.81601,22.62525});
//        path.add(new double[]{113.81601,22.62525});
//        path.add(new double[]{113.81562,22.62516});
//        path.add(new double[]{113.81562,22.62516});
//        path.add(new double[]{113.81544,22.62502});
//        path.add(new double[]{113.81379,22.62418});



//        path.add(new double[]{113.95589,22.53916});
//        path.add(new double[]{113.95594,22.53898});
//        path.add(new double[]{113.95594,22.53898});
//        path.add(new double[]{113.95555,22.53898});
//        path.add(new double[]{113.95555,22.53898});
//        path.add(new double[]{113.95491,22.53896});
//        path.add(new double[]{113.95491,22.53896});
//        path.add(new double[]{113.95445,22.53896});
//        path.add(new double[]{113.95445,22.53896});
//        path.add(new double[]{113.95395,22.53895});
//        path.add(new double[]{113.95395,22.53895});
//        path.add(new double[]{113.95396,22.5392});
//        path.add(new double[]{113.95396,22.5392});
//        path.add(new double[]{113.95396,22.53938});
//        path.add(new double[]{113.95396,22.53938});
//        path.add(new double[]{113.95395,22.53965});
//        path.add(new double[]{113.95395,22.53965});
//        path.add(new double[]{113.95394,22.53987});
//        path.add(new double[]{113.95394,22.53987});
//        path.add(new double[]{113.95393,22.54012});
//        path.add(new double[]{113.95393,22.54012});
//        path.add(new double[]{113.95394,22.54038});
//        path.add(new double[]{113.95394,22.54038});
//        path.add(new double[]{113.95386,22.54038});
//        path.add(new double[]{113.95386,22.54038});
//        path.add(new double[]{113.95357,22.54036});
//        path.add(new double[]{113.95357,22.54036});
//        path.add(new double[]{113.95329,22.54035});
//        path.add(new double[]{113.95329,22.54035});
//        path.add(new double[]{113.95295,22.54034});
//        path.add(new double[]{113.95295,22.54034});
//        path.add(new double[]{113.95225,22.54031});
//        path.add(new double[]{113.95225,22.54031});
//        path.add(new double[]{113.95198,22.5403});
//        path.add(new double[]{113.95198,22.5403});
//        path.add(new double[]{113.95171,22.54028});
//        path.add(new double[]{113.95171,22.54028});
//        path.add(new double[]{113.95131,22.54026});
//        path.add(new double[]{113.95131,22.54026});
//        path.add(new double[]{113.94914,22.54016});
//        path.add(new double[]{113.94914,22.54016});
//        path.add(new double[]{113.94805,22.54012});
//        path.add(new double[]{113.94805,22.54012});
//        path.add(new double[]{113.94786,22.54009});
//        path.add(new double[]{113.94786,22.54009});
//        path.add(new double[]{113.94742,22.54008});
//        path.add(new double[]{113.94742,22.54008});
//        path.add(new double[]{113.94695,22.54006});
//        path.add(new double[]{113.94695,22.54006});
//        path.add(new double[]{113.9463,22.54003});
//        path.add(new double[]{113.9463,22.54003});
//        path.add(new double[]{113.94578,22.54001});
//        path.add(new double[]{113.94578,22.54001});
//        path.add(new double[]{113.94552,22.54});
//        path.add(new double[]{113.94552,22.54});
//        path.add(new double[]{113.94532,22.53999});
//        path.add(new double[]{113.94532,22.53999});
//        path.add(new double[]{113.94465,22.53995});
//        path.add(new double[]{113.94465,22.53995});
//        path.add(new double[]{113.94331,22.53989});
//        path.add(new double[]{113.94331,22.53989});
//        path.add(new double[]{113.94292,22.53988});
//        path.add(new double[]{113.94292,22.53988});
//        path.add(new double[]{113.9417,22.53982});
//        path.add(new double[]{113.9417,22.53982});
//        path.add(new double[]{113.94114,22.53979});
//        path.add(new double[]{113.94114,22.53979});
//        path.add(new double[]{113.94052,22.53976});
//        path.add(new double[]{113.94052,22.53976});
//        path.add(new double[]{113.93915,22.5397});
//        path.add(new double[]{113.93915,22.5397});
//        path.add(new double[]{113.93794,22.53965});
//        path.add(new double[]{113.93794,22.53965});
//        path.add(new double[]{113.9374,22.53965});





//        path.add(new double[]{113.95606,22.53871});
//        path.add(new double[]{113.95617,22.53871});
//        path.add(new double[]{113.95633,22.53865});
//        path.add(new double[]{113.95652,22.5385});
//        path.add(new double[]{113.95652,22.5385});
//        path.add(new double[]{113.95656,22.53853});
//        path.add(new double[]{113.95656,22.53853});
//        path.add(new double[]{113.95664,22.53858});
//        path.add(new double[]{113.95664,22.53858});
//        path.add(new double[]{113.9568,22.53836});
//        path.add(new double[]{113.9568,22.53836});
//        path.add(new double[]{113.95696,22.53814});
//        path.add(new double[]{113.95696,22.53814});
//        path.add(new double[]{113.95699,22.53804});
//        path.add(new double[]{113.95698,22.53794});
//        path.add(new double[]{113.95698,22.53794});
//        path.add(new double[]{113.9569,22.53776});
//        path.add(new double[]{113.9569,22.53776});
//        path.add(new double[]{113.95686,22.53769});
//        path.add(new double[]{113.95686,22.53769});
//        path.add(new double[]{113.95682,22.53764});
//        path.add(new double[]{113.95682,22.53764});
//        path.add(new double[]{113.95673,22.53748});
//        path.add(new double[]{113.95673,22.53748});
//        path.add(new double[]{113.95665,22.53734});
//        path.add(new double[]{113.95665,22.53734});
//        path.add(new double[]{113.95642,22.53698});
//        path.add(new double[]{113.95642,22.53698});
//        path.add(new double[]{113.95639,22.53692});
//        path.add(new double[]{113.95639,22.53692});
//        path.add(new double[]{113.95618,22.53656});
//        path.add(new double[]{113.95618,22.53656});
//        path.add(new double[]{113.95616,22.53653});
//        path.add(new double[]{113.95616,22.53653});
//        path.add(new double[]{113.956,22.53628});
//        path.add(new double[]{113.956,22.53628});
//        path.add(new double[]{113.95563,22.53569});
//        path.add(new double[]{113.95563,22.53569});
//        path.add(new double[]{113.95559,22.5356});
//        path.add(new double[]{113.95559,22.5356});
//        path.add(new double[]{113.95559,22.53552});
//        path.add(new double[]{113.95559,22.53552});
//        path.add(new double[]{113.95643,22.53511});
//        path.add(new double[]{113.95643,22.53511});
//        path.add(new double[]{113.95656,22.53492});
//        path.add(new double[]{113.95656,22.53473});
//        path.add(new double[]{113.95656,22.53473});
//        path.add(new double[]{113.95636,22.53443});
//        path.add(new double[]{113.95636,22.53443});
//        path.add(new double[]{113.95628,22.5343});
//        path.add(new double[]{113.95628,22.5343});
//        path.add(new double[]{113.95537,22.53281});
//        path.add(new double[]{113.95509,22.53217});
//        path.add(new double[]{113.95491,22.53157});
//        path.add(new double[]{113.95491,22.53157});
//        path.add(new double[]{113.95488,22.53091});
//        path.add(new double[]{113.95488,22.53091});
//        path.add(new double[]{113.95474,22.52854});
//        path.add(new double[]{113.95474,22.52854});
//        path.add(new double[]{113.95473,22.52832});
//        path.add(new double[]{113.95473,22.52832});
//        path.add(new double[]{113.95469,22.52788});
//        path.add(new double[]{113.95469,22.52788});
//        path.add(new double[]{113.95465,22.52719});
//        path.add(new double[]{113.95465,22.52719});
//        path.add(new double[]{113.95465,22.52711});
//        path.add(new double[]{113.95465,22.52711});
//        path.add(new double[]{113.95461,22.52674});
//        path.add(new double[]{113.95461,22.52674});
//        path.add(new double[]{113.95454,22.52608});
//        path.add(new double[]{113.95454,22.52608});
//        path.add(new double[]{113.95452,22.52587});
//        path.add(new double[]{113.95452,22.52587});
//        path.add(new double[]{113.95436,22.5247});
//        path.add(new double[]{113.95431,22.52408});
//        path.add(new double[]{113.95431,22.52408});
//        path.add(new double[]{113.95429,22.52398});
//        path.add(new double[]{113.95429,22.52398});
//        path.add(new double[]{113.954,22.52162});
//        path.add(new double[]{113.954,22.52162});
//        path.add(new double[]{113.9539,22.52095});
//        path.add(new double[]{113.9539,22.52095});
//        path.add(new double[]{113.95383,22.5203});
//        path.add(new double[]{113.95383,22.5203});
//        path.add(new double[]{113.9536,22.51968});
//        path.add(new double[]{113.95354,22.51959});
//        path.add(new double[]{113.95336,22.51945});
//        path.add(new double[]{113.95317,22.51939});
//        path.add(new double[]{113.95301,22.51938});
//        path.add(new double[]{113.95268,22.51949});
//        path.add(new double[]{113.95256,22.51965});
//        path.add(new double[]{113.95247,22.51989});
//        path.add(new double[]{113.95247,22.52012});
//        path.add(new double[]{113.95254,22.52033});
//        path.add(new double[]{113.95268,22.52048});
//        path.add(new double[]{113.95286,22.52057});
//        path.add(new double[]{113.95299,22.52061});
//        path.add(new double[]{113.9533,22.52064});
//        path.add(new double[]{113.9533,22.52064});
//        path.add(new double[]{113.95413,22.52057});
//        path.add(new double[]{113.95413,22.52057});
//        path.add(new double[]{113.95463,22.52052});
//        path.add(new double[]{113.95463,22.52052});
//        path.add(new double[]{113.95626,22.52033});
//        path.add(new double[]{113.95626,22.52033});
//        path.add(new double[]{113.95718,22.52051});
//        path.add(new double[]{113.95718,22.52051});
//        path.add(new double[]{113.95804,22.52042});
//        path.add(new double[]{113.95804,22.52042});
//        path.add(new double[]{113.95985,22.52022});
//        path.add(new double[]{113.95985,22.52022});
//        path.add(new double[]{113.9621,22.51996});
//        path.add(new double[]{113.9621,22.51996});
//        path.add(new double[]{113.96358,22.51978});
//        path.add(new double[]{113.96531,22.51971});
//        path.add(new double[]{113.96656,22.51973});
//        path.add(new double[]{113.96656,22.51973});
//        path.add(new double[]{113.96691,22.51974});
//        path.add(new double[]{113.96691,22.51974});
//        path.add(new double[]{113.96738,22.51975});
//        path.add(new double[]{113.96738,22.51975});
//        path.add(new double[]{113.96758,22.51975});
//        path.add(new double[]{113.96758,22.51975});
//        path.add(new double[]{113.96896,22.51974});
//        path.add(new double[]{113.96896,22.51974});
//        path.add(new double[]{113.96924,22.51974});
//        path.add(new double[]{113.96924,22.51974});
//        path.add(new double[]{113.97381,22.51978});
//        path.add(new double[]{113.97381,22.51978});
//        path.add(new double[]{113.97773,22.51984});
//        path.add(new double[]{113.97773,22.51984});
//        path.add(new double[]{113.97836,22.51985});
//        path.add(new double[]{113.97836,22.51985});
//        path.add(new double[]{113.97851,22.51984});
//        path.add(new double[]{113.97851,22.51984});
//        path.add(new double[]{113.97989,22.51984});
//        path.add(new double[]{113.97989,22.51984});
//        path.add(new double[]{113.98053,22.51985});
//        path.add(new double[]{113.98053,22.51985});
//        path.add(new double[]{113.98079,22.51985});
//        path.add(new double[]{113.98079,22.51985});
//        path.add(new double[]{113.98415,22.51986});
//        path.add(new double[]{113.98415,22.51986});
//        path.add(new double[]{113.9852,22.51986});
//        path.add(new double[]{113.98561,22.51989});
//        path.add(new double[]{113.98561,22.51989});
//        path.add(new double[]{113.98656,22.51994});
//        path.add(new double[]{113.98656,22.51994});
//        path.add(new double[]{113.98854,22.52022});
//        path.add(new double[]{113.98854,22.52022});
//        path.add(new double[]{113.98983,22.52045});
//        path.add(new double[]{113.99076,22.52067});
//        path.add(new double[]{113.99076,22.52067});
//        path.add(new double[]{113.99159,22.52088});
//        path.add(new double[]{113.99242,22.52115});
//        path.add(new double[]{113.99242,22.52115});
//        path.add(new double[]{113.99291,22.52131});
//        path.add(new double[]{113.99291,22.52131});
//        path.add(new double[]{113.9939,22.52168});
//        path.add(new double[]{113.9939,22.52168});
//        path.add(new double[]{113.99475,22.52202});
//        path.add(new double[]{113.99582,22.52249});
//        path.add(new double[]{113.9961,22.52264});
//        path.add(new double[]{113.9961,22.52264});
//        path.add(new double[]{113.9968,22.52303});
//        path.add(new double[]{113.9968,22.52303});
//        path.add(new double[]{113.99844,22.524});
//        path.add(new double[]{113.99977,22.52483});
//        path.add(new double[]{113.99977,22.52483});
//        path.add(new double[]{114.0,22.52496});
//        path.add(new double[]{114.0,22.52496});
//        path.add(new double[]{114.00035,22.52514});
//        path.add(new double[]{114.00076,22.5254});
//        path.add(new double[]{114.00076,22.5254});
//        path.add(new double[]{114.00123,22.52574});
//        path.add(new double[]{114.00158,22.52592});
//        path.add(new double[]{114.00158,22.52592});
//        path.add(new double[]{114.00161,22.52594});
//        path.add(new double[]{114.00161,22.52594});
//        path.add(new double[]{114.00192,22.52604});
//        path.add(new double[]{114.00192,22.52604});
//        path.add(new double[]{114.00288,22.5264});
//        path.add(new double[]{114.00288,22.5264});
//        path.add(new double[]{114.00336,22.52658});
//        path.add(new double[]{114.00419,22.52682});
//        path.add(new double[]{114.00511,22.52701});
//        path.add(new double[]{114.00573,22.52709});
//        path.add(new double[]{114.00649,22.52716});
//        path.add(new double[]{114.00757,22.52716});
//        path.add(new double[]{114.00862,22.52708});
//        path.add(new double[]{114.00862,22.52708});
//        path.add(new double[]{114.01145,22.52675});
//        path.add(new double[]{114.01252,22.52668});
//        path.add(new double[]{114.01341,22.5267});
//        path.add(new double[]{114.01439,22.52681});
//        path.add(new double[]{114.01439,22.52681});
//        path.add(new double[]{114.01457,22.52684});
//        path.add(new double[]{114.01457,22.52684});
//        path.add(new double[]{114.01513,22.52693});
//        path.add(new double[]{114.01513,22.52693});
//        path.add(new double[]{114.01624,22.52715});
//        path.add(new double[]{114.01624,22.52715});
//        path.add(new double[]{114.01894,22.52779});
//        path.add(new double[]{114.01894,22.52779});
//        path.add(new double[]{114.01981,22.52798});
//        path.add(new double[]{114.01981,22.52798});
//        path.add(new double[]{114.0208,22.52821});
//        path.add(new double[]{114.0208,22.52821});
//        path.add(new double[]{114.02134,22.52833});
//        path.add(new double[]{114.02134,22.52833});
//        path.add(new double[]{114.02172,22.52844});
//        path.add(new double[]{114.0224,22.52858});
//        path.add(new double[]{114.0224,22.52858});
//        path.add(new double[]{114.02492,22.52911});
//        path.add(new double[]{114.02571,22.52917});
//        path.add(new double[]{114.02571,22.52917});
//        path.add(new double[]{114.02711,22.5291});
//        path.add(new double[]{114.02711,22.5291});
//        path.add(new double[]{114.02795,22.529});
//        path.add(new double[]{114.02795,22.529});
//        path.add(new double[]{114.02846,22.52888});
//        path.add(new double[]{114.02846,22.52888});
//        path.add(new double[]{114.02948,22.52864});
//        path.add(new double[]{114.02948,22.52864});
//        path.add(new double[]{114.03027,22.52842});
//        path.add(new double[]{114.03376,22.52764});
//        path.add(new double[]{114.03376,22.52764});
//        path.add(new double[]{114.03444,22.52751});
//        path.add(new double[]{114.03444,22.52751});
//        path.add(new double[]{114.03549,22.52737});
//        path.add(new double[]{114.03549,22.52737});
//        path.add(new double[]{114.03592,22.52732});
//        path.add(new double[]{114.03677,22.52729});
//        path.add(new double[]{114.03677,22.52729});
//        path.add(new double[]{114.03755,22.52728});
//        path.add(new double[]{114.03755,22.52728});
//        path.add(new double[]{114.03902,22.52737});
//        path.add(new double[]{114.04047,22.52753});
//        path.add(new double[]{114.04047,22.52753});
//        path.add(new double[]{114.04196,22.5277});
//        path.add(new double[]{114.04196,22.5277});
//        path.add(new double[]{114.04421,22.52798});
//        path.add(new double[]{114.04421,22.52798});
//        path.add(new double[]{114.04488,22.52807});
//        path.add(new double[]{114.04488,22.52807});
//        path.add(new double[]{114.04752,22.52833});
//        path.add(new double[]{114.04752,22.52833});
//        path.add(new double[]{114.04965,22.52855});
//        path.add(new double[]{114.05084,22.52858});
//        path.add(new double[]{114.05084,22.52858});
//        path.add(new double[]{114.05155,22.5286});
//        path.add(new double[]{114.05155,22.5286});
//        path.add(new double[]{114.0523,22.52861});
//        path.add(new double[]{114.0523,22.52861});
//        path.add(new double[]{114.054,22.52865});
//        path.add(new double[]{114.054,22.52865});
//        path.add(new double[]{114.05506,22.52866});
//        path.add(new double[]{114.05506,22.52866});
//        path.add(new double[]{114.05704,22.5287});
//        path.add(new double[]{114.05704,22.5287});
//        path.add(new double[]{114.06267,22.52881});
//        path.add(new double[]{114.06267,22.52881});
//        path.add(new double[]{114.06468,22.52885});
//        path.add(new double[]{114.06468,22.52885});
//        path.add(new double[]{114.06617,22.52886});
//        path.add(new double[]{114.06617,22.52886});
//        path.add(new double[]{114.06652,22.52886});
//        path.add(new double[]{114.06652,22.52886});
//        path.add(new double[]{114.06877,22.5289});
//        path.add(new double[]{114.06877,22.5289});
//        path.add(new double[]{114.07035,22.52893});
//        path.add(new double[]{114.07035,22.52893});
//        path.add(new double[]{114.07124,22.52896});
//        path.add(new double[]{114.07124,22.52896});
//        path.add(new double[]{114.07166,22.52895});
//        path.add(new double[]{114.07166,22.52895});
//        path.add(new double[]{114.07539,22.529});
//        path.add(new double[]{114.07539,22.529});
//        path.add(new double[]{114.07571,22.52901});
//        path.add(new double[]{114.07571,22.52901});
//        path.add(new double[]{114.07766,22.52904});
//        path.add(new double[]{114.07766,22.52904});
//        path.add(new double[]{114.07856,22.52905});
//        path.add(new double[]{114.07856,22.52905});
//        path.add(new double[]{114.08074,22.52909});
//        path.add(new double[]{114.08074,22.52909});
//        path.add(new double[]{114.08159,22.52912});
//        path.add(new double[]{114.08159,22.52912});
//        path.add(new double[]{114.08178,22.52914});
//        path.add(new double[]{114.08199,22.52921});
//        path.add(new double[]{114.0824,22.52942});
//        path.add(new double[]{114.08267,22.52964});
//        path.add(new double[]{114.08294,22.52998});
//        path.add(new double[]{114.08294,22.52998});
//        path.add(new double[]{114.08335,22.53067});
//        path.add(new double[]{114.08411,22.53212});
//        path.add(new double[]{114.08411,22.53212});
//        path.add(new double[]{114.08462,22.53297});
//        path.add(new double[]{114.08462,22.53297});
//        path.add(new double[]{114.08471,22.5331});
//        path.add(new double[]{114.08471,22.5331});
//        path.add(new double[]{114.0851,22.53354});
//        path.add(new double[]{114.08555,22.53391});
//        path.add(new double[]{114.08555,22.53391});
//        path.add(new double[]{114.08571,22.53402});
//        path.add(new double[]{114.08622,22.53426});
//        path.add(new double[]{114.08677,22.53446});
//        path.add(new double[]{114.08677,22.53446});
//        path.add(new double[]{114.08699,22.53452});
//        path.add(new double[]{114.0875,22.53458});
//        path.add(new double[]{114.0875,22.53458});
//        path.add(new double[]{114.08887,22.53462});
//        path.add(new double[]{114.08887,22.53462});
//        path.add(new double[]{114.08917,22.53462});
//        path.add(new double[]{114.08917,22.53462});
//        path.add(new double[]{114.09176,22.53466});
//        path.add(new double[]{114.09271,22.53471});
//        path.add(new double[]{114.09271,22.53471});
//        path.add(new double[]{114.09338,22.53479});
//        path.add(new double[]{114.09338,22.53479});
//        path.add(new double[]{114.09365,22.53483});
//        path.add(new double[]{114.09365,22.53483});
//        path.add(new double[]{114.09629,22.53534});
//        path.add(new double[]{114.09629,22.53534});
//        path.add(new double[]{114.09674,22.53538});
//        path.add(new double[]{114.09674,22.53538});
//        path.add(new double[]{114.1,22.53535});
//        path.add(new double[]{114.1,22.53535});
//        path.add(new double[]{114.10272,22.53538});
//        path.add(new double[]{114.10272,22.53538});
//        path.add(new double[]{114.10366,22.53539});
//        path.add(new double[]{114.10366,22.53539});
//        path.add(new double[]{114.10443,22.5354});
//        path.add(new double[]{114.10443,22.5354});
//        path.add(new double[]{114.10477,22.53541});
//        path.add(new double[]{114.10477,22.53541});
//        path.add(new double[]{114.10634,22.53543});
//        path.add(new double[]{114.10634,22.53543});
//        path.add(new double[]{114.1071,22.53544});
//        path.add(new double[]{114.1071,22.53544});
//        path.add(new double[]{114.10749,22.53545});
//        path.add(new double[]{114.10749,22.53545});
//        path.add(new double[]{114.10824,22.53544});
//        path.add(new double[]{114.10824,22.53544});
//        path.add(new double[]{114.1086,22.5354});
//        path.add(new double[]{114.1086,22.5354});
//        path.add(new double[]{114.10895,22.53533});
//        path.add(new double[]{114.10941,22.53516});
//        path.add(new double[]{114.10941,22.53516});
//        path.add(new double[]{114.11011,22.53481});
//        path.add(new double[]{114.11011,22.53481});
//        path.add(new double[]{114.11022,22.53476});
//        path.add(new double[]{114.11022,22.53476});
//        path.add(new double[]{114.11036,22.53469});
//        path.add(new double[]{114.11036,22.53469});
//        path.add(new double[]{114.11065,22.53454});
//        path.add(new double[]{114.11065,22.53454});
//        path.add(new double[]{114.11104,22.53437});
//        path.add(new double[]{114.11143,22.53428});
//        path.add(new double[]{114.11143,22.53428});
//        path.add(new double[]{114.1119,22.53428});
//        path.add(new double[]{114.1119,22.53428});
//        path.add(new double[]{114.11231,22.53435});
//        path.add(new double[]{114.11406,22.53481});
//        path.add(new double[]{114.11406,22.53481});
//        path.add(new double[]{114.11471,22.53493});
//        path.add(new double[]{114.11471,22.53493});
//        path.add(new double[]{114.11521,22.535});
//        path.add(new double[]{114.11521,22.535});
//        path.add(new double[]{114.11639,22.53516});
//        path.add(new double[]{114.11639,22.53516});
//        path.add(new double[]{114.11703,22.53524});
//        path.add(new double[]{114.1184,22.53549});
//        path.add(new double[]{114.11925,22.53576});
//        path.add(new double[]{114.11925,22.53576});
//        path.add(new double[]{114.11988,22.53598});
//        path.add(new double[]{114.11988,22.53598});
//        path.add(new double[]{114.12031,22.53614});
//        path.add(new double[]{114.12031,22.53614});
//        path.add(new double[]{114.12067,22.53628});
//        path.add(new double[]{114.12067,22.53628});
//        path.add(new double[]{114.12146,22.53656});
//        path.add(new double[]{114.12168,22.53657});
//        path.add(new double[]{114.12187,22.53654});
//        path.add(new double[]{114.12211,22.53638});
//        path.add(new double[]{114.12246,22.53583});
//        path.add(new double[]{114.12246,22.53583});
//        path.add(new double[]{114.12283,22.53529});
//        path.add(new double[]{114.12294,22.53518});
//        path.add(new double[]{114.12294,22.53518});
//        path.add(new double[]{114.12316,22.53502});
//        path.add(new double[]{114.12316,22.53502});
//        path.add(new double[]{114.12343,22.53492});
//        path.add(new double[]{114.12379,22.53492});
//        path.add(new double[]{114.12379,22.53492});
//        path.add(new double[]{114.12408,22.53502});
//        path.add(new double[]{114.12458,22.53534});
//        path.add(new double[]{114.12458,22.53534});
//        path.add(new double[]{114.125,22.53562});
//        path.add(new double[]{114.125,22.53562});
//        path.add(new double[]{114.12555,22.53598});
//        path.add(new double[]{114.12555,22.53598});
//        path.add(new double[]{114.12728,22.53709});
//        path.add(new double[]{114.12728,22.53709});
//        path.add(new double[]{114.12884,22.53815});
//        path.add(new double[]{114.12884,22.53815});
//        path.add(new double[]{114.12961,22.53865});
//        path.add(new double[]{114.13104,22.53951});
//        path.add(new double[]{114.13167,22.53984});
//        path.add(new double[]{114.13167,22.53984});
//        path.add(new double[]{114.13511,22.54162});
//        path.add(new double[]{114.13511,22.54162});
//        path.add(new double[]{114.13615,22.54216});
//        path.add(new double[]{114.13615,22.54216});
//        path.add(new double[]{114.13663,22.54242});
//        path.add(new double[]{114.13663,22.54242});
//        path.add(new double[]{114.13724,22.54274});
//        path.add(new double[]{114.13724,22.54274});
//        path.add(new double[]{114.13853,22.54347});
//        path.add(new double[]{114.13853,22.54347});
//        path.add(new double[]{114.1389,22.5437});
//        path.add(new double[]{114.13926,22.54397});
//        path.add(new double[]{114.13974,22.54447});
//        path.add(new double[]{114.14019,22.54506});
//        path.add(new double[]{114.14019,22.54506});
//        path.add(new double[]{114.14069,22.54585});
//        path.add(new double[]{114.14069,22.54585});
//        path.add(new double[]{114.14164,22.54733});
//        path.add(new double[]{114.14164,22.54733});
//        path.add(new double[]{114.14221,22.54821});
//        path.add(new double[]{114.14221,22.54821});
//        path.add(new double[]{114.14253,22.54864});
//        path.add(new double[]{114.14253,22.54864});
//        path.add(new double[]{114.1435,22.55006});
//        path.add(new double[]{114.1435,22.55006});
//        path.add(new double[]{114.1438,22.55029});
//        path.add(new double[]{114.1438,22.55029});
//        path.add(new double[]{114.14392,22.55051});
//        path.add(new double[]{114.14392,22.55051});
//        path.add(new double[]{114.14422,22.55109});
//        path.add(new double[]{114.14422,22.55109});
//        path.add(new double[]{114.14433,22.55132});
//        path.add(new double[]{114.14433,22.55132});
//        path.add(new double[]{114.1445,22.55163});
//        path.add(new double[]{114.14473,22.55185});
//        path.add(new double[]{114.14628,22.55279});
//        path.add(new double[]{114.14628,22.55279});
//        path.add(new double[]{114.14653,22.55289});
//        path.add(new double[]{114.14694,22.55294});
//        path.add(new double[]{114.14694,22.55294});
//        path.add(new double[]{114.14802,22.55282});
//        path.add(new double[]{114.14802,22.55282});
//        path.add(new double[]{114.14858,22.55271});
//        path.add(new double[]{114.14858,22.55271});
//        path.add(new double[]{114.14892,22.55267});
//        path.add(new double[]{114.14892,22.55267});
//        path.add(new double[]{114.149,22.55267});
//        path.add(new double[]{114.149,22.55267});
//        path.add(new double[]{114.14916,22.55266});
//        path.add(new double[]{114.14916,22.55266});
//        path.add(new double[]{114.14944,22.55263});
//        path.add(new double[]{114.14944,22.55263});
//        path.add(new double[]{114.14989,22.55259});
//        path.add(new double[]{114.14989,22.55259});
//        path.add(new double[]{114.15,22.55258});
//        path.add(new double[]{114.15,22.55258});
//        path.add(new double[]{114.1508,22.55255});
//        path.add(new double[]{114.15104,22.55257});
//        path.add(new double[]{114.15104,22.55257});
//        path.add(new double[]{114.15158,22.55265});
//        path.add(new double[]{114.15158,22.55265});
//        path.add(new double[]{114.15166,22.55267});
//        path.add(new double[]{114.15166,22.55267});
//        path.add(new double[]{114.15254,22.55284});
//        path.add(new double[]{114.15254,22.55284});
//        path.add(new double[]{114.1552,22.55339});
//        path.add(new double[]{114.1552,22.55339});
//        path.add(new double[]{114.15543,22.55343});
//        path.add(new double[]{114.15543,22.55343});
//        path.add(new double[]{114.15547,22.55344});
//        path.add(new double[]{114.15547,22.55344});
//        path.add(new double[]{114.15567,22.55348});
//        path.add(new double[]{114.15567,22.55348});
//        path.add(new double[]{114.15583,22.55352});
//        path.add(new double[]{114.15583,22.55352});
//        path.add(new double[]{114.15611,22.55362});
//        path.add(new double[]{114.15611,22.55362});
//        path.add(new double[]{114.15632,22.5537});
//        path.add(new double[]{114.15632,22.5537});
//        path.add(new double[]{114.15674,22.55387});
//        path.add(new double[]{114.15708,22.55405});
//        path.add(new double[]{114.15708,22.55405});
//        path.add(new double[]{114.15729,22.55417});
//        path.add(new double[]{114.15729,22.55417});
//        path.add(new double[]{114.15769,22.55447});
//        path.add(new double[]{114.15769,22.55447});
//        path.add(new double[]{114.15791,22.55464});
//        path.add(new double[]{114.15791,22.55464});
//        path.add(new double[]{114.15826,22.55492});
//        path.add(new double[]{114.15826,22.55492});
//        path.add(new double[]{114.15854,22.55514});
//        path.add(new double[]{114.15854,22.55514});
//        path.add(new double[]{114.15874,22.5553});
//        path.add(new double[]{114.15874,22.5553});
//        path.add(new double[]{114.15947,22.55588});
//        path.add(new double[]{114.15947,22.55588});
//        path.add(new double[]{114.16,22.5563});
//        path.add(new double[]{114.16,22.5563});
//        path.add(new double[]{114.16025,22.5565});
//        path.add(new double[]{114.16025,22.5565});
//        path.add(new double[]{114.1608,22.55693});
//        path.add(new double[]{114.1608,22.55693});
//        path.add(new double[]{114.16116,22.55721});
//        path.add(new double[]{114.16116,22.55721});
//        path.add(new double[]{114.16133,22.55735});
//        path.add(new double[]{114.16133,22.55735});
//        path.add(new double[]{114.16157,22.55754});
//        path.add(new double[]{114.16157,22.55754});
//        path.add(new double[]{114.16222,22.55803});
//        path.add(new double[]{114.16222,22.55803});
//        path.add(new double[]{114.16237,22.55813});
//        path.add(new double[]{114.16237,22.55813});
//        path.add(new double[]{114.16317,22.55856});
//        path.add(new double[]{114.16317,22.55856});
//        path.add(new double[]{114.1642,22.55901});
//        path.add(new double[]{114.1642,22.55901});
//        path.add(new double[]{114.16487,22.55928});
//        path.add(new double[]{114.16487,22.55928});
//        path.add(new double[]{114.16559,22.55957});
//        path.add(new double[]{114.16559,22.55957});
//        path.add(new double[]{114.16595,22.55972});
//        path.add(new double[]{114.16671,22.55987});
//        path.add(new double[]{114.16729,22.55991});
//        path.add(new double[]{114.16908,22.55989});
//        path.add(new double[]{114.16908,22.55989});
//        path.add(new double[]{114.16972,22.5599});
//        path.add(new double[]{114.16972,22.5599});
//        path.add(new double[]{114.17111,22.55991});
//        path.add(new double[]{114.17111,22.55991});
//        path.add(new double[]{114.17256,22.55993});
//        path.add(new double[]{114.17256,22.55993});
//        path.add(new double[]{114.17332,22.55995});
//        path.add(new double[]{114.17332,22.55995});
//        path.add(new double[]{114.17507,22.55996});
//        path.add(new double[]{114.17507,22.55996});
//        path.add(new double[]{114.17583,22.55997});
//        path.add(new double[]{114.17583,22.55997});
//        path.add(new double[]{114.17608,22.55999});
//        path.add(new double[]{114.17608,22.55999});
//        path.add(new double[]{114.17649,22.56});
//        path.add(new double[]{114.17649,22.56});
//        path.add(new double[]{114.17709,22.55998});
//        path.add(new double[]{114.17709,22.55998});
//        path.add(new double[]{114.17747,22.55994});
//        path.add(new double[]{114.17747,22.55994});
//        path.add(new double[]{114.17802,22.55986});
//        path.add(new double[]{114.17802,22.55986});
//        path.add(new double[]{114.17868,22.55967});
//        path.add(new double[]{114.17909,22.55951});
//        path.add(new double[]{114.17909,22.55951});
//        path.add(new double[]{114.17955,22.55932});
//        path.add(new double[]{114.17955,22.55932});
//        path.add(new double[]{114.17993,22.55911});
//        path.add(new double[]{114.18084,22.55852});
//        path.add(new double[]{114.18084,22.55852});
//        path.add(new double[]{114.18112,22.55833});
//        path.add(new double[]{114.18112,22.55833});
//        path.add(new double[]{114.18145,22.55808});
//        path.add(new double[]{114.18145,22.55808});
//        path.add(new double[]{114.18254,22.55729});
//        path.add(new double[]{114.18254,22.55729});
//        path.add(new double[]{114.18342,22.55661});
//        path.add(new double[]{114.18342,22.55661});
//        path.add(new double[]{114.18367,22.55641});
//        path.add(new double[]{114.18367,22.55641});
//        path.add(new double[]{114.18511,22.55534});
//        path.add(new double[]{114.18682,22.55414});
//        path.add(new double[]{114.18682,22.55414});
//        path.add(new double[]{114.18734,22.55384});
//        path.add(new double[]{114.18734,22.55384});
//        path.add(new double[]{114.18776,22.55369});
//        path.add(new double[]{114.18807,22.55362});
//        path.add(new double[]{114.18807,22.55362});
//        path.add(new double[]{114.18931,22.55343});
//        path.add(new double[]{114.18931,22.55343});
//        path.add(new double[]{114.18962,22.5534});
//        path.add(new double[]{114.18962,22.5534});
//        path.add(new double[]{114.19038,22.55333});
//        path.add(new double[]{114.19038,22.55333});
//        path.add(new double[]{114.19199,22.55323});
//        path.add(new double[]{114.19199,22.55323});
//        path.add(new double[]{114.19277,22.55318});
//        path.add(new double[]{114.19277,22.55318});
//        path.add(new double[]{114.19429,22.55306});
//        path.add(new double[]{114.19429,22.55306});
//        path.add(new double[]{114.19509,22.55308});
//        path.add(new double[]{114.19575,22.55318});
//        path.add(new double[]{114.19575,22.55318});
//        path.add(new double[]{114.19654,22.55342});
//        path.add(new double[]{114.19654,22.55342});
//        path.add(new double[]{114.19666,22.55344});
//        path.add(new double[]{114.19666,22.55344});
//        path.add(new double[]{114.19714,22.55355});
//        path.add(new double[]{114.19714,22.55355});
//        path.add(new double[]{114.19814,22.55383});
//        path.add(new double[]{114.19814,22.55383});
//        path.add(new double[]{114.20041,22.55444});
//        path.add(new double[]{114.20184,22.55474});
//        path.add(new double[]{114.20382,22.555});
//        path.add(new double[]{114.20484,22.55509});
//        path.add(new double[]{114.20662,22.5551});
//        path.add(new double[]{114.20817,22.55506});
//        path.add(new double[]{114.21119,22.55488});
//        path.add(new double[]{114.21835,22.55452});
//        path.add(new double[]{114.22026,22.55447});
//        path.add(new double[]{114.22026,22.55447});
//        path.add(new double[]{114.2207,22.55445});
//        path.add(new double[]{114.2207,22.55445});
//        path.add(new double[]{114.22079,22.55445});
//        path.add(new double[]{114.22079,22.55445});
//        path.add(new double[]{114.22155,22.55442});
//        path.add(new double[]{114.22155,22.55442});
//        path.add(new double[]{114.22204,22.5544});
//        path.add(new double[]{114.22204,22.5544});
//        path.add(new double[]{114.22248,22.55437});
//        path.add(new double[]{114.22248,22.55437});
//        path.add(new double[]{114.22253,22.55437});
//        path.add(new double[]{114.22253,22.55437});
//        path.add(new double[]{114.22351,22.55432});
//        path.add(new double[]{114.22351,22.55432});
//        path.add(new double[]{114.22362,22.55431});
//        path.add(new double[]{114.22362,22.55431});
//        path.add(new double[]{114.22427,22.55429});
//        path.add(new double[]{114.22427,22.55429});
//        path.add(new double[]{114.22443,22.55429});
//        path.add(new double[]{114.22443,22.55429});
//        path.add(new double[]{114.22481,22.55428});
//        path.add(new double[]{114.22481,22.55428});
//        path.add(new double[]{114.22673,22.55423});
//        path.add(new double[]{114.22673,22.55423});
//        path.add(new double[]{114.22691,22.55422});
//        path.add(new double[]{114.22691,22.55422});
//        path.add(new double[]{114.22716,22.5542});
//        path.add(new double[]{114.22716,22.5542});
//        path.add(new double[]{114.22768,22.55415});
//        path.add(new double[]{114.22768,22.55415});
//        path.add(new double[]{114.22824,22.55407});
//        path.add(new double[]{114.22824,22.55407});
//        path.add(new double[]{114.22853,22.55403});
//        path.add(new double[]{114.22853,22.55403});
//        path.add(new double[]{114.22865,22.55401});
//        path.add(new double[]{114.22865,22.55401});
//        path.add(new double[]{114.22893,22.55397});
//        path.add(new double[]{114.22893,22.55397});
//        path.add(new double[]{114.23053,22.55375});
//        path.add(new double[]{114.23053,22.55375});
//        path.add(new double[]{114.23062,22.55373});
//        path.add(new double[]{114.23062,22.55373});
//        path.add(new double[]{114.23221,22.55353});
//        path.add(new double[]{114.23221,22.55353});
//        path.add(new double[]{114.23295,22.55343});
//        path.add(new double[]{114.23295,22.55343});
//        path.add(new double[]{114.23361,22.55339});
//        path.add(new double[]{114.23361,22.55339});
//        path.add(new double[]{114.23387,22.55341});
//        path.add(new double[]{114.23387,22.55341});
//        path.add(new double[]{114.23411,22.55345});
//        path.add(new double[]{114.23411,22.55345});
//        path.add(new double[]{114.23423,22.55348});
//        path.add(new double[]{114.23423,22.55348});
//        path.add(new double[]{114.23458,22.55362});
//        path.add(new double[]{114.23523,22.55401});
//        path.add(new double[]{114.23523,22.55401});
//        path.add(new double[]{114.23631,22.55462});
//        path.add(new double[]{114.23631,22.55462});
//        path.add(new double[]{114.23663,22.55481});
//        path.add(new double[]{114.23663,22.55481});
//        path.add(new double[]{114.23672,22.55487});
//        path.add(new double[]{114.23672,22.55487});
//        path.add(new double[]{114.23807,22.55571});
//        path.add(new double[]{114.23807,22.55571});
//        path.add(new double[]{114.23866,22.55606});
//        path.add(new double[]{114.23866,22.55606});
//        path.add(new double[]{114.23885,22.55617});
//        path.add(new double[]{114.23885,22.55617});
//        path.add(new double[]{114.23917,22.55636});
//        path.add(new double[]{114.23917,22.55636});
//        path.add(new double[]{114.23929,22.55642});
//        path.add(new double[]{114.23929,22.55642});
//        path.add(new double[]{114.23978,22.55683});
//        path.add(new double[]{114.23978,22.55683});
//        path.add(new double[]{114.24131,22.5584});
//        path.add(new double[]{114.24131,22.5584});
//        path.add(new double[]{114.24203,22.55912});
//        path.add(new double[]{114.24203,22.55912});
//        path.add(new double[]{114.24234,22.5594});
//        path.add(new double[]{114.24267,22.5596});
//        path.add(new double[]{114.24267,22.5596});
//        path.add(new double[]{114.24296,22.55975});
//        path.add(new double[]{114.24296,22.55975});
//        path.add(new double[]{114.24303,22.55978});
//        path.add(new double[]{114.24303,22.55978});
//        path.add(new double[]{114.24516,22.56076});
//        path.add(new double[]{114.24516,22.56076});
//        path.add(new double[]{114.24542,22.5609});
//        path.add(new double[]{114.24542,22.5609});
//        path.add(new double[]{114.24567,22.56107});
//        path.add(new double[]{114.24567,22.56107});
//        path.add(new double[]{114.24577,22.56116});
//        path.add(new double[]{114.24577,22.56116});
//        path.add(new double[]{114.24594,22.56131});
//        path.add(new double[]{114.24594,22.56131});
//        path.add(new double[]{114.246,22.56137});
//        path.add(new double[]{114.246,22.56137});
//        path.add(new double[]{114.24629,22.56173});
//        path.add(new double[]{114.24689,22.56236});
//        path.add(new double[]{114.24689,22.56236});
//        path.add(new double[]{114.24745,22.56298});
//        path.add(new double[]{114.24745,22.56298});
//        path.add(new double[]{114.24754,22.56308});
//        path.add(new double[]{114.24754,22.56308});
//        path.add(new double[]{114.24778,22.56328});
//        path.add(new double[]{114.24778,22.56328});
//        path.add(new double[]{114.24816,22.56364});
//        path.add(new double[]{114.24816,22.56364});
//        path.add(new double[]{114.24832,22.56379});
//        path.add(new double[]{114.24832,22.56379});
//        path.add(new double[]{114.24945,22.56486});
//        path.add(new double[]{114.24945,22.56486});
//        path.add(new double[]{114.24966,22.56505});
//        path.add(new double[]{114.24966,22.56505});
//        path.add(new double[]{114.25,22.56536});
//        path.add(new double[]{114.25,22.56536});
//        path.add(new double[]{114.25086,22.56614});
//        path.add(new double[]{114.25145,22.56672});
//        path.add(new double[]{114.25173,22.56708});
//        path.add(new double[]{114.25238,22.56817});
//        path.add(new double[]{114.25238,22.56817});
//        path.add(new double[]{114.25245,22.56827});
//        path.add(new double[]{114.25245,22.56827});
//        path.add(new double[]{114.25257,22.56847});
//        path.add(new double[]{114.25257,22.56847});
//        path.add(new double[]{114.25263,22.56856});
//        path.add(new double[]{114.25263,22.56856});
//        path.add(new double[]{114.25276,22.56874});
//        path.add(new double[]{114.25276,22.56874});
//        path.add(new double[]{114.25295,22.56887});
//        path.add(new double[]{114.25304,22.56898});
//        path.add(new double[]{114.25304,22.56898});
//        path.add(new double[]{114.25342,22.5694});
//        path.add(new double[]{114.25342,22.5694});
//        path.add(new double[]{114.25375,22.56977});
//        path.add(new double[]{114.25375,22.56977});
//        path.add(new double[]{114.25385,22.56989});
//        path.add(new double[]{114.25385,22.56989});
//        path.add(new double[]{114.25518,22.57141});
//        path.add(new double[]{114.25518,22.57141});
//        path.add(new double[]{114.25601,22.57226});
//        path.add(new double[]{114.25601,22.57226});
//        path.add(new double[]{114.25616,22.57229});
//        path.add(new double[]{114.25616,22.57229});
//        path.add(new double[]{114.25645,22.57241});
//        path.add(new double[]{114.25657,22.57258});
//        path.add(new double[]{114.25657,22.57258});
//        path.add(new double[]{114.25659,22.57267});
//        path.add(new double[]{114.25659,22.57267});
//        path.add(new double[]{114.25784,22.57368});
//        path.add(new double[]{114.25784,22.57368});
//        path.add(new double[]{114.25851,22.57422});
//        path.add(new double[]{114.25851,22.57422});
//        path.add(new double[]{114.25855,22.57446});
//        path.add(new double[]{114.25855,22.57446});
//        path.add(new double[]{114.25887,22.57469});
//        path.add(new double[]{114.25887,22.57469});
//        path.add(new double[]{114.25911,22.57485});
//        path.add(new double[]{114.25911,22.57485});
//        path.add(new double[]{114.26051,22.57603});
//        path.add(new double[]{114.26051,22.57603});
//        path.add(new double[]{114.26066,22.57618});
//        path.add(new double[]{114.26066,22.57618});
//        path.add(new double[]{114.2608,22.5763});
//        path.add(new double[]{114.2608,22.5763});
//        path.add(new double[]{114.26152,22.57687});
//        path.add(new double[]{114.26152,22.57687});
//        path.add(new double[]{114.26266,22.57779});
//        path.add(new double[]{114.26266,22.57779});
//        path.add(new double[]{114.26289,22.57797});
//        path.add(new double[]{114.26289,22.57797});
//        path.add(new double[]{114.26352,22.57847});
//        path.add(new double[]{114.26352,22.57847});
//        path.add(new double[]{114.2638,22.5787});
//        path.add(new double[]{114.2638,22.5787});
//        path.add(new double[]{114.26414,22.57898});
//        path.add(new double[]{114.26414,22.57898});
//        path.add(new double[]{114.26488,22.57953});
//        path.add(new double[]{114.26615,22.58057});
//        path.add(new double[]{114.26615,22.58057});
//        path.add(new double[]{114.26643,22.58082});
//        path.add(new double[]{114.26643,22.58082});
//        path.add(new double[]{114.26664,22.581});
//        path.add(new double[]{114.26664,22.581});
//        path.add(new double[]{114.26713,22.58152});
//        path.add(new double[]{114.26742,22.58189});
//        path.add(new double[]{114.26742,22.58189});
//        path.add(new double[]{114.26768,22.58223});
//        path.add(new double[]{114.26768,22.58223});
//        path.add(new double[]{114.26796,22.5826});
//        path.add(new double[]{114.26796,22.5826});
//        path.add(new double[]{114.2684,22.58323});
//        path.add(new double[]{114.2684,22.58323});
//        path.add(new double[]{114.26848,22.58333});
//        path.add(new double[]{114.26848,22.58333});
//        path.add(new double[]{114.26853,22.5834});
//        path.add(new double[]{114.26853,22.5834});
//        path.add(new double[]{114.26878,22.58372});
//        path.add(new double[]{114.26878,22.58372});
//        path.add(new double[]{114.26893,22.58393});
//        path.add(new double[]{114.26893,22.58393});
//        path.add(new double[]{114.26927,22.58438});
//        path.add(new double[]{114.26927,22.58438});
//        path.add(new double[]{114.26947,22.58461});
//        path.add(new double[]{114.26947,22.58461});
//        path.add(new double[]{114.2695,22.5846});
//        path.add(new double[]{114.2695,22.5846});
//        path.add(new double[]{114.26975,22.58489});
//        path.add(new double[]{114.26975,22.58489});
//        path.add(new double[]{114.27,22.58514});
//        path.add(new double[]{114.27,22.58514});
//        path.add(new double[]{114.27015,22.58529});
//        path.add(new double[]{114.27015,22.58529});
//        path.add(new double[]{114.2706,22.58585});
//        path.add(new double[]{114.2706,22.58585});
//        path.add(new double[]{114.27081,22.58609});
//        path.add(new double[]{114.27105,22.58626});
//        path.add(new double[]{114.27105,22.58626});
//        path.add(new double[]{114.27184,22.58682});
//        path.add(new double[]{114.27184,22.58682});
//        path.add(new double[]{114.27203,22.58693});
//        path.add(new double[]{114.27203,22.58693});
//        path.add(new double[]{114.2726,22.58724});
//        path.add(new double[]{114.2726,22.58724});
//        path.add(new double[]{114.2728,22.58736});
//        path.add(new double[]{114.2728,22.58736});
//        path.add(new double[]{114.27301,22.58746});
//        path.add(new double[]{114.27301,22.58746});
//        path.add(new double[]{114.2733,22.58755});
//        path.add(new double[]{114.2733,22.58755});
//        path.add(new double[]{114.27345,22.58759});
//        path.add(new double[]{114.27345,22.58759});
//        path.add(new double[]{114.27366,22.5876});
//        path.add(new double[]{114.27366,22.5876});
//        path.add(new double[]{114.27401,22.58762});
//        path.add(new double[]{114.27401,22.58762});
//        path.add(new double[]{114.27461,22.58749});
//        path.add(new double[]{114.27487,22.58739});
//        path.add(new double[]{114.27487,22.58739});
//        path.add(new double[]{114.27487,22.58746});
//        path.add(new double[]{114.27487,22.58746});
//        path.add(new double[]{114.2749,22.58765});
//        path.add(new double[]{114.27494,22.58772});
//        path.add(new double[]{114.27494,22.58772});
//        path.add(new double[]{114.27504,22.58772});
//        path.add(new double[]{114.27504,22.58772});
//        path.add(new double[]{114.27527,22.5878});
//        path.add(new double[]{114.27527,22.5878});
//        path.add(new double[]{114.27551,22.58786});
//        path.add(new double[]{114.27551,22.58786});
//        path.add(new double[]{114.27674,22.58788});
//        path.add(new double[]{114.27809,22.58766});
//        path.add(new double[]{114.27809,22.58766});
//        path.add(new double[]{114.27851,22.58763});
//        path.add(new double[]{114.27851,22.58763});
//        path.add(new double[]{114.27878,22.58761});
//        path.add(new double[]{114.27878,22.58761});
//        path.add(new double[]{114.27912,22.58757});
//        path.add(new double[]{114.27912,22.58757});
//        path.add(new double[]{114.27941,22.58752});
//        path.add(new double[]{114.2796,22.58741});
//        path.add(new double[]{114.2796,22.58741});
//        path.add(new double[]{114.27967,22.58737});
//        path.add(new double[]{114.27967,22.58737});
//        path.add(new double[]{114.27998,22.5871});
//        path.add(new double[]{114.27998,22.5871});
//        path.add(new double[]{114.28025,22.58687});
//        path.add(new double[]{114.28025,22.58687});
//        path.add(new double[]{114.28108,22.58671});
//        path.add(new double[]{114.28141,22.58659});
//        path.add(new double[]{114.28169,22.58653});
//        path.add(new double[]{114.28351,22.58651});
//        path.add(new double[]{114.28351,22.58651});
//        path.add(new double[]{114.28421,22.58649});
//        path.add(new double[]{114.28421,22.58649});
//        path.add(new double[]{114.28468,22.58649});
//        path.add(new double[]{114.28468,22.58649});
//        path.add(new double[]{114.28551,22.58648});
//        path.add(new double[]{114.28551,22.58648});
//        path.add(new double[]{114.28593,22.5866});
//        path.add(new double[]{114.28593,22.5866});
//        path.add(new double[]{114.28631,22.58677});
//        path.add(new double[]{114.28659,22.58683});
//        path.add(new double[]{114.28696,22.58684});
//        path.add(new double[]{114.28696,22.58684});
//        path.add(new double[]{114.28703,22.58684});
//        path.add(new double[]{114.28703,22.58684});
//        path.add(new double[]{114.28756,22.58687});
//        path.add(new double[]{114.28792,22.58678});
//        path.add(new double[]{114.28902,22.58618});
//        path.add(new double[]{114.28942,22.58603});
//        path.add(new double[]{114.28942,22.58603});
//        path.add(new double[]{114.29,22.58598});
//        path.add(new double[]{114.29077,22.58586});
//        path.add(new double[]{114.29077,22.58586});
//        path.add(new double[]{114.29134,22.5857});
//        path.add(new double[]{114.29163,22.58552});
//        path.add(new double[]{114.29179,22.58533});
//        path.add(new double[]{114.29179,22.58533});
//        path.add(new double[]{114.29195,22.58514});
//        path.add(new double[]{114.29221,22.58495});
//        path.add(new double[]{114.29221,22.58495});
//        path.add(new double[]{114.29239,22.58481});
//        path.add(new double[]{114.29283,22.58467});
//        path.add(new double[]{114.29323,22.58462});
//        path.add(new double[]{114.29323,22.58462});
//        path.add(new double[]{114.29342,22.5846});
//        path.add(new double[]{114.29476,22.5842});
//        path.add(new double[]{114.29476,22.5842});
//        path.add(new double[]{114.29607,22.58387});
//        path.add(new double[]{114.29607,22.58387});
//        path.add(new double[]{114.2963,22.58383});
//        path.add(new double[]{114.29681,22.58381});
//        path.add(new double[]{114.29717,22.58368});
//        path.add(new double[]{114.29759,22.58333});
//        path.add(new double[]{114.29759,22.58333});
//        path.add(new double[]{114.29771,22.58323});
//        path.add(new double[]{114.29771,22.58323});
//        path.add(new double[]{114.29796,22.58303});
//        path.add(new double[]{114.29796,22.58303});
//        path.add(new double[]{114.29822,22.58282});
//        path.add(new double[]{114.29848,22.58268});
//        path.add(new double[]{114.29869,22.58267});
//        path.add(new double[]{114.29891,22.58279});
//        path.add(new double[]{114.29925,22.58312});
//        path.add(new double[]{114.29952,22.58324});
//        path.add(new double[]{114.29999,22.58333});
//        path.add(new double[]{114.29999,22.58333});
//        path.add(new double[]{114.30015,22.58336});
//        path.add(new double[]{114.30031,22.58333});
//        path.add(new double[]{114.30031,22.58333});
//        path.add(new double[]{114.30084,22.58316});
//        path.add(new double[]{114.30084,22.58316});
//        path.add(new double[]{114.30174,22.58286});
//        path.add(new double[]{114.30205,22.58286});
//        path.add(new double[]{114.30244,22.58291});
//        path.add(new double[]{114.30289,22.58279});
//        path.add(new double[]{114.3033,22.5826});
//        path.add(new double[]{114.30358,22.58234});
//        path.add(new double[]{114.30358,22.58234});
//        path.add(new double[]{114.30364,22.58229});
//        path.add(new double[]{114.30394,22.58219});
//        path.add(new double[]{114.30463,22.58217});
//        path.add(new double[]{114.3048,22.58214});
//        path.add(new double[]{114.3048,22.58214});
//        path.add(new double[]{114.30498,22.5821});
//        path.add(new double[]{114.30498,22.5821});
//        path.add(new double[]{114.30562,22.58199});
//        path.add(new double[]{114.30579,22.58203});
//        path.add(new double[]{114.30579,22.58203});
//        path.add(new double[]{114.30588,22.58206});
//        path.add(new double[]{114.30603,22.58222});
//        path.add(new double[]{114.30607,22.58245});
//        path.add(new double[]{114.30605,22.58265});
//        path.add(new double[]{114.30605,22.58265});
//        path.add(new double[]{114.30602,22.58291});
//        path.add(new double[]{114.30602,22.58291});
//        path.add(new double[]{114.306,22.58333});
//        path.add(new double[]{114.306,22.58333});
//        path.add(new double[]{114.30606,22.58349});
//        path.add(new double[]{114.30616,22.58364});
//        path.add(new double[]{114.30617,22.5839});
//        path.add(new double[]{114.30609,22.58412});
//        path.add(new double[]{114.30575,22.58432});
//        path.add(new double[]{114.30575,22.58432});
//        path.add(new double[]{114.30552,22.58442});
//        path.add(new double[]{114.30516,22.58493});
//        path.add(new double[]{114.30516,22.58493});
//        path.add(new double[]{114.30493,22.58551});
//        path.add(new double[]{114.30442,22.58591});
//        path.add(new double[]{114.30442,22.58591});
//        path.add(new double[]{114.30401,22.58621});
//        path.add(new double[]{114.30401,22.58621});
//        path.add(new double[]{114.30391,22.58637});
//        path.add(new double[]{114.30388,22.58652});
//        path.add(new double[]{114.30389,22.58735});
//        path.add(new double[]{114.30382,22.58777});
//        path.add(new double[]{114.30382,22.58777});
//        path.add(new double[]{114.30375,22.5882});
//        path.add(new double[]{114.30378,22.58853});
//        path.add(new double[]{114.30391,22.58911});
//        path.add(new double[]{114.30391,22.58911});
//        path.add(new double[]{114.30403,22.58942});
//        path.add(new double[]{114.30431,22.5897});
//        path.add(new double[]{114.30431,22.5897});
//        path.add(new double[]{114.3045,22.58985});
//        path.add(new double[]{114.3045,22.58985});
//        path.add(new double[]{114.30487,22.59012});
//        path.add(new double[]{114.30487,22.59012});
//        path.add(new double[]{114.30509,22.59032});
//        path.add(new double[]{114.30509,22.59032});
//        path.add(new double[]{114.30533,22.59069});
//        path.add(new double[]{114.30533,22.59069});
//        path.add(new double[]{114.3054,22.5908});
//        path.add(new double[]{114.3054,22.5908});
//        path.add(new double[]{114.30573,22.59145});
//        path.add(new double[]{114.30573,22.59145});
//        path.add(new double[]{114.30579,22.59156});
//        path.add(new double[]{114.30579,22.59156});
//        path.add(new double[]{114.30582,22.59164});
//        path.add(new double[]{114.30582,22.59164});
//        path.add(new double[]{114.30593,22.59187});
//        path.add(new double[]{114.30593,22.59187});
//        path.add(new double[]{114.30605,22.59213});
//        path.add(new double[]{114.30654,22.59281});
//        path.add(new double[]{114.30654,22.59281});
//        path.add(new double[]{114.30725,22.5935});
//        path.add(new double[]{114.30799,22.59407});
//        path.add(new double[]{114.30843,22.5945});
//        path.add(new double[]{114.30843,22.5945});
//        path.add(new double[]{114.30868,22.59476});
//        path.add(new double[]{114.30868,22.59476});
//        path.add(new double[]{114.30923,22.59538});
//        path.add(new double[]{114.30923,22.59538});
//        path.add(new double[]{114.3094,22.59563});
//        path.add(new double[]{114.3094,22.59563});
//        path.add(new double[]{114.31044,22.59712});
//        path.add(new double[]{114.31092,22.59761});
//        path.add(new double[]{114.31121,22.59786});
//        path.add(new double[]{114.31121,22.59786});
//        path.add(new double[]{114.31145,22.59804});
//        path.add(new double[]{114.31145,22.59804});
//        path.add(new double[]{114.31156,22.5981});
//        path.add(new double[]{114.31156,22.5981});
//        path.add(new double[]{114.31147,22.59818});
//        path.add(new double[]{114.31147,22.59818});
//        path.add(new double[]{114.31119,22.59842});
//        path.add(new double[]{114.31119,22.59842});
//        path.add(new double[]{114.31089,22.59865});
//        path.add(new double[]{114.31089,22.59865});
//        path.add(new double[]{114.31071,22.59881});
//        path.add(new double[]{114.31071,22.59881});
//        path.add(new double[]{114.31065,22.59885});
//        path.add(new double[]{114.31065,22.59885});
//        path.add(new double[]{114.31051,22.59897});
//        path.add(new double[]{114.31051,22.59897});
//        path.add(new double[]{114.31039,22.59907});
    }


    private Routine routine;

    private LandMark landMark;



    private List<double[]> readyData;

    @Override
    protected void onStart() {
        super.onStart();

        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

        //去掉重复的点，很重要！不然计算相对角时有问题
        filterDuplicatedPoints(path);
        readyData = new ArrayList<>();
        readyData.clear();
        readyData.addAll(path);
//        readyData = routePrepare(path);
//        filterDuplicatedPoints(readyData);

//        routine = new Routine(path);
        landMark = new LandMark(point.x, point.y);



        mGlSurfaceView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mGlSurfaceView.requestRender();

                if (currPosition < path.size() - 2) {
                    mGlSurfaceView.postDelayed(this, 1000);
                }
            }
        }, 1000);

    }

    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

//        long startTime = System.currentTimeMillis();
//        Log.e("ssssssss", "drawScene start ===>"+startTime);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();


        float[] eyePosition = {0,5,10};
        GLU.gluLookAt(gl, eyePosition[0],eyePosition[1],eyePosition[2], 0,0,0, 0,1,0);


        gl.glPushMatrix();

        antiSmooth(gl);


//        printAllPointAngle();
//        printPointAngle(2);

//        printAllPointAngle();

        // TODO: 2017/4/25 多角度 设置路标
//        calculateTurnAngle(path.subList(currPosition, currPosition + 10));

//        landMark.setAngle(getComingTurnDirection());
//        landMark.setTurnDirection(getComingTurnDirection());
//        landMark.draw(gl);
//        routine.draw(gl);



        int size = currPosition +20;
        if (size > readyData.size()) {
            size = readyData.size();
        }
//        landMark.setComingDirection(0, calculateTurnAngle(readyData.subList(currPosition, size)));
//        landMark.draw6(gl);
//        landMark.setAngle(calculateTurnAngle(readyData.subList(currPosition, size)));
//        landMark.draw(gl);

        int angle = calculateComingTurn(readyData.subList(currPosition, readyData.size()));
        Log.e("ssssss", "angle:"+angle);

        landMark.drawAngleWithDistance(gl, 100d, angle);



        gl.glPopMatrix();
//        long endTime = System.currentTimeMillis();
//        Log.e("ssssssss", "drawScene end ===>"+ endTime + " duration:"+(endTime - startTime));
//        Log.e("sssssss", "sssss currPosition:"+currPosition);

        currPosition ++;
//        mDistance +=5;

    }

    private int currPosition = 0;

    private double getDisanceBetweenPoints(double[] first, double[] second) {
        double distance = Util.getrelativeDistance(first[0], first[1], second[0], second[1]);
        return distance;
    }

    private int getAngleBetweenPoints(double[] first, double[] second) {
        int angle = Util.LngLatToOrient(first[0], first[1], second[0], second[1]);
        return angle;
    }

    private int getCurrentTurnAngle() {
        //到路径起点或者终点时，无转弯角度
        if (currPosition > path.size() - 2 || currPosition == 0) {
            return 0;
        }

        //根据当前点，前点，后点，计算转向角度
        return calculateturnAngle(path.get(currPosition-1), path.get(currPosition), path.get(currPosition+1));
    }

    /**
     *
     * @return [distance, angle]
     */

    // TODO: 2017/4/24 for test
    private double mDistance = 0;
    private double[] getComingTurnDirection() {

        if (currPosition > path.size() - 3) {
            return new double[]{0,0};
        }

        //距离下一个转向小于 100 米，提示转向
        double disance = getDisanceBetweenPoints(path.get(currPosition), path.get(currPosition+1));
        disance -= mDistance;

//        Log.e("sssss ", "distance to next turn:"+disance);
        if (disance <5) {
            currPosition ++;

            mDistance = 0;

            disance = getDisanceBetweenPoints(path.get(currPosition), path.get(currPosition+1));
            disance -= mDistance;
        }

        mDistance += 2;

        int angle = calculateturnAngle(path.get(currPosition), path.get(currPosition+1), path.get(currPosition+2));
        return new double[]{disance, angle};
    }


    private double getDistanceToNextTurn() {
        double distance = getDisanceBetweenPoints(path.get(currPosition), path.get(currPosition+1));
//        distance -= mDistance;
//        if (distance < 10f) {
//            currPosition++;
//            distance = getDisanceBetweenPoints(path.get(currPosition), path.get(currPosition+1));
//
//            mDistance = 0;
//        }

//        Log.e("s", "distance to turn:"+distance+ "  indx:"+currPosition);
        return distance;
    }

//    private List<Integer> calculateTurnAngle(List<double[]> points) {
//        ArrayList<Integer> angles = new ArrayList<>();
//        if (points.size() <3) {
//            angles.add(0);
//        }else if (points.size() == 3) {
//            angles.add(calculateturnAngle(points.get(0), points.get(1), points.get(2)));
//        }else {
//            int count = points.size() -2;
//            angles.add(calculateturnAngle(points.get(0), points.get(1), points.get(2)));
//
//            for (int i=1; i< count; i++) {
//                int angle = calculateturnAngle(points.get(i), points.get(i+1), points.get(i+2));
//                int sign = angle * angles.get(angles.size()-1);
//                if (sign >0) {
//                    angles.set(angles.size()-1, angles.get(angles.size()-1) + angle);
//                }else {
//                    angles.add(angle);
//                }
//            }
//        }
//
////        for (int a : angles) {
////            Log.e("ssss", "angle:"+a);
////        }
//        return angles;
//    }

    private int calculateTurnAngle(List<double[]> points) {
        int angle ;
        if (points.size() <3) {
            angle = 0;
        }else if (points.size() == 3) {
           angle = calculateturnAngle(points.get(0), points.get(1), points.get(2));
        }else {
            int count = points.size() -2;
            angle = calculateturnAngle(points.get(0), points.get(1), points.get(2));

            for (int i=1; i< count; i++) {
                int tmp = calculateturnAngle(points.get(i), points.get(i+1), points.get(i+2));
                int sign = angle * tmp;
                if (sign >0) {
                    angle += tmp;
                } else {
                    break;
                }
            }
        }

//        for (int a : angles) {
//            Log.e("ssss", "angle:"+angle);
//        }
        return angle;
    }


    private List<double[]> routePrepare(List<double[]> route) {
        if (route.size() < 2) {
            return route;
        }

        List<double[]> result = new ArrayList<>();
        for (int i = 1; i< route.size() -1; i++) {
            result.addAll(routePointInsert(route.get(i-1), route.get(i)));
        }
        return result;
    }

    /**
     * 路径插值，每10米插一个点
     * @return
     */
    private List<double[]> routePointInsert(double[] first, double[] second) {
        double distance = getDisanceBetweenPoints(first, second);

        List<double[]> routePoints = new ArrayList<>();

        if (distance > 10) {
            int count = (int) Math.ceil(distance / 10);
            double stepX = (second[0] - first[0]) / count;
            double stepY = (second[1] - first[1]) / count;

            for (int i=0; i <= count; i++) {
                routePoints.add(new double[] {first[0] + stepX * i, first[1] + stepY * i});
            }

        }else {
            routePoints.add(first);
            routePoints.add(second);
        }

        return routePoints;
    }


    /**
     * 根据过弯方向显示下一个弯
     */
    private int calculateComingTurn(List<double[]> path) {
        int angle;
        int size = path.size();
        if (size <3) {
            angle = 0;
        }else {
            angle = calculateturnAngle(path.get(0), path.get(1), path.get(2));
            for (int i=1; i< size -2; i++) {
                int tem = calculateturnAngle(path.get(i), path.get(i+1), path.get(i+2));
                if (angle * tem >0) {
                    //转向一致
                    angle += tem;
                }else {
                    Log.e("sss", "use to point id: "+i);
                    break;
                }
            }
        }

        return angle;
    }



    /**
     * 根据三个点，计算转向
     */
    private int calculateturnAngle(double[] first, double[] second, double[] third) {
        //根据当前点，前点，后点，计算转向角度
        int angleNow = getAngleBetweenPoints(first, second);
        int angleComing = getAngleBetweenPoints(second, third);
        int turnAngle = angleNow - angleComing;

        /**
         * [-180, 180]
         */
        if (turnAngle < -180) {
            turnAngle += 360;
        }else if (turnAngle > 180) {
            turnAngle -= 360;
        }

//        Log.e("sssss ", "now==>"+angleNow + " comming==>"+ angleComing+"  turn angle==>"+(turnAngle));
//        Log.e("sssss ", "-------------------------------");

        return turnAngle;
    }

    private void printAllPointAngle() {
        getCurrentTurnAngle();
    }

    private void printPointAngle(int currPosition) {
        int angleNow = 0;
        if (currPosition ==0) {
            angleNow = 0;
        }else {
            angleNow = getAngleBetweenPoints(path.get(currPosition - 1), path.get(currPosition));
        }
        Log.e("sssss ", "point"+currPosition+"=====>"+(angleNow));
    }

    private void filterDuplicatedPoints(List<double[]> path) {
        printAllPoints();
        double[] first;
        double[] second;

        List<double[]> deleted = new ArrayList<>();

        for (int i=1; i<path.size(); i++) {
            first = path.get(i-1);
            second = path.get(i);
            if (Math.abs(first[0] - second[0]) < Double.MIN_VALUE
                    && Math.abs(first[1] - second[1]) < Double.MIN_VALUE) {
                deleted.add(path.get(i));
            }
        }

        path.removeAll(deleted);
        Log.e("sssss ", "--------------------------------------------------------------------------");
        printAllPoints();
    }

    private void printAllPoints() {
        for (double[] point :
                path) {
            System.out.println(String.format("%f, %f", point[0], point[1]));
        }
        System.out.println(String.format("size: %d", path.size()));
    }
}
