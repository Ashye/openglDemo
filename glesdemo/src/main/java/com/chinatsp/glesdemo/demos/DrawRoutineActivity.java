package com.chinatsp.glesdemo.demos;

import android.opengl.GLU;
import android.util.Log;

import com.chinatsp.glesdemo.demos.Model.Routine;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public class DrawRoutineActivity extends OpenGLESActivity {

    //经纬度
    private Vector<double[]> path = new Vector<>();


    {
        path.add(new double[]{113.95606,22.53871});
        path.add(new double[]{113.95617,22.53871});
        path.add(new double[]{113.95633,22.53865});
        path.add(new double[]{113.95652,22.5385});
        path.add(new double[]{113.95652,22.5385});
        path.add(new double[]{113.95656,22.53853});
        path.add(new double[]{113.95656,22.53853});
        path.add(new double[]{113.95664,22.53858});
        path.add(new double[]{113.95664,22.53858});
        path.add(new double[]{113.9568,22.53836});
        path.add(new double[]{113.9568,22.53836});
        path.add(new double[]{113.95696,22.53814});
        path.add(new double[]{113.95696,22.53814});
        path.add(new double[]{113.95699,22.53804});
        path.add(new double[]{113.95698,22.53794});
        path.add(new double[]{113.95698,22.53794});
        path.add(new double[]{113.9569,22.53776});
        path.add(new double[]{113.9569,22.53776});
        path.add(new double[]{113.95686,22.53769});
        path.add(new double[]{113.95686,22.53769});
        path.add(new double[]{113.95682,22.53764});
        path.add(new double[]{113.95682,22.53764});
        path.add(new double[]{113.95673,22.53748});
        path.add(new double[]{113.95673,22.53748});
        path.add(new double[]{113.95665,22.53734});
        path.add(new double[]{113.95665,22.53734});
        path.add(new double[]{113.95642,22.53698});
        path.add(new double[]{113.95642,22.53698});
        path.add(new double[]{113.95639,22.53692});
        path.add(new double[]{113.95639,22.53692});
        path.add(new double[]{113.95618,22.53656});
        path.add(new double[]{113.95618,22.53656});
        path.add(new double[]{113.95616,22.53653});
        path.add(new double[]{113.95616,22.53653});
        path.add(new double[]{113.956,22.53628});
        path.add(new double[]{113.956,22.53628});
        path.add(new double[]{113.95563,22.53569});
        path.add(new double[]{113.95563,22.53569});
        path.add(new double[]{113.95559,22.5356});
        path.add(new double[]{113.95559,22.5356});
        path.add(new double[]{113.95559,22.53552});
        path.add(new double[]{113.95559,22.53552});
        path.add(new double[]{113.95643,22.53511});
        path.add(new double[]{113.95643,22.53511});
        path.add(new double[]{113.95656,22.53492});
        path.add(new double[]{113.95656,22.53473});
        path.add(new double[]{113.95656,22.53473});
        path.add(new double[]{113.95636,22.53443});
        path.add(new double[]{113.95636,22.53443});
        path.add(new double[]{113.95628,22.5343});
        path.add(new double[]{113.95628,22.5343});
        path.add(new double[]{113.95537,22.53281});
        path.add(new double[]{113.95509,22.53217});
        path.add(new double[]{113.95491,22.53157});
        path.add(new double[]{113.95491,22.53157});
        path.add(new double[]{113.95488,22.53091});
        path.add(new double[]{113.95488,22.53091});
        path.add(new double[]{113.95474,22.52854});
        path.add(new double[]{113.95474,22.52854});
        path.add(new double[]{113.95473,22.52832});
        path.add(new double[]{113.95473,22.52832});
        path.add(new double[]{113.95469,22.52788});
        path.add(new double[]{113.95469,22.52788});
        path.add(new double[]{113.95465,22.52719});
        path.add(new double[]{113.95465,22.52719});
        path.add(new double[]{113.95465,22.52711});
        path.add(new double[]{113.95465,22.52711});
        path.add(new double[]{113.95461,22.52674});
        path.add(new double[]{113.95461,22.52674});
        path.add(new double[]{113.95454,22.52608});
        path.add(new double[]{113.95454,22.52608});
        path.add(new double[]{113.95452,22.52587});
        path.add(new double[]{113.95452,22.52587});
        path.add(new double[]{113.95436,22.5247});
        path.add(new double[]{113.95431,22.52408});
        path.add(new double[]{113.95431,22.52408});
        path.add(new double[]{113.95429,22.52398});
        path.add(new double[]{113.95429,22.52398});
        path.add(new double[]{113.954,22.52162});
        path.add(new double[]{113.954,22.52162});
        path.add(new double[]{113.9539,22.52095});
        path.add(new double[]{113.9539,22.52095});
        path.add(new double[]{113.95383,22.5203});
        path.add(new double[]{113.95383,22.5203});
        path.add(new double[]{113.9536,22.51968});
        path.add(new double[]{113.95354,22.51959});
        path.add(new double[]{113.95336,22.51945});
        path.add(new double[]{113.95317,22.51939});
        path.add(new double[]{113.95301,22.51938});
        path.add(new double[]{113.95268,22.51949});
        path.add(new double[]{113.95256,22.51965});
        path.add(new double[]{113.95247,22.51989});
        path.add(new double[]{113.95247,22.52012});
        path.add(new double[]{113.95254,22.52033});
        path.add(new double[]{113.95268,22.52048});
        path.add(new double[]{113.95286,22.52057});
        path.add(new double[]{113.95299,22.52061});
        path.add(new double[]{113.9533,22.52064});
        path.add(new double[]{113.9533,22.52064});
        path.add(new double[]{113.95413,22.52057});
        path.add(new double[]{113.95413,22.52057});
        path.add(new double[]{113.95463,22.52052});
        path.add(new double[]{113.95463,22.52052});
        path.add(new double[]{113.95626,22.52033});
        path.add(new double[]{113.95626,22.52033});
        path.add(new double[]{113.95718,22.52051});
        path.add(new double[]{113.95718,22.52051});
        path.add(new double[]{113.95804,22.52042});
        path.add(new double[]{113.95804,22.52042});
        path.add(new double[]{113.95985,22.52022});
        path.add(new double[]{113.95985,22.52022});
        path.add(new double[]{113.9621,22.51996});
        path.add(new double[]{113.9621,22.51996});
        path.add(new double[]{113.96358,22.51978});
        path.add(new double[]{113.96531,22.51971});
        path.add(new double[]{113.96656,22.51973});
        path.add(new double[]{113.96656,22.51973});
        path.add(new double[]{113.96691,22.51974});
        path.add(new double[]{113.96691,22.51974});
        path.add(new double[]{113.96738,22.51975});
        path.add(new double[]{113.96738,22.51975});
        path.add(new double[]{113.96758,22.51975});
        path.add(new double[]{113.96758,22.51975});
        path.add(new double[]{113.96896,22.51974});
        path.add(new double[]{113.96896,22.51974});
        path.add(new double[]{113.96924,22.51974});
        path.add(new double[]{113.96924,22.51974});
        path.add(new double[]{113.97381,22.51978});
        path.add(new double[]{113.97381,22.51978});
        path.add(new double[]{113.97773,22.51984});
        path.add(new double[]{113.97773,22.51984});
        path.add(new double[]{113.97836,22.51985});
        path.add(new double[]{113.97836,22.51985});
        path.add(new double[]{113.97851,22.51984});
        path.add(new double[]{113.97851,22.51984});
        path.add(new double[]{113.97989,22.51984});
        path.add(new double[]{113.97989,22.51984});
        path.add(new double[]{113.98053,22.51985});
        path.add(new double[]{113.98053,22.51985});
        path.add(new double[]{113.98079,22.51985});
        path.add(new double[]{113.98079,22.51985});
        path.add(new double[]{113.98415,22.51986});
        path.add(new double[]{113.98415,22.51986});
        path.add(new double[]{113.9852,22.51986});
        path.add(new double[]{113.98561,22.51989});
        path.add(new double[]{113.98561,22.51989});
        path.add(new double[]{113.98656,22.51994});
        path.add(new double[]{113.98656,22.51994});
        path.add(new double[]{113.98854,22.52022});
        path.add(new double[]{113.98854,22.52022});
        path.add(new double[]{113.98983,22.52045});
        path.add(new double[]{113.99076,22.52067});
        path.add(new double[]{113.99076,22.52067});
        path.add(new double[]{113.99159,22.52088});
        path.add(new double[]{113.99242,22.52115});
        path.add(new double[]{113.99242,22.52115});
        path.add(new double[]{113.99291,22.52131});
        path.add(new double[]{113.99291,22.52131});
        path.add(new double[]{113.9939,22.52168});
        path.add(new double[]{113.9939,22.52168});
        path.add(new double[]{113.99475,22.52202});
        path.add(new double[]{113.99582,22.52249});
        path.add(new double[]{113.9961,22.52264});
        path.add(new double[]{113.9961,22.52264});
        path.add(new double[]{113.9968,22.52303});
        path.add(new double[]{113.9968,22.52303});
        path.add(new double[]{113.99844,22.524});
        path.add(new double[]{113.99977,22.52483});
        path.add(new double[]{113.99977,22.52483});
        path.add(new double[]{114.0,22.52496});
        path.add(new double[]{114.0,22.52496});
        path.add(new double[]{114.00035,22.52514});
        path.add(new double[]{114.00076,22.5254});
        path.add(new double[]{114.00076,22.5254});
        path.add(new double[]{114.00123,22.52574});
        path.add(new double[]{114.00158,22.52592});
        path.add(new double[]{114.00158,22.52592});
        path.add(new double[]{114.00161,22.52594});
        path.add(new double[]{114.00161,22.52594});
        path.add(new double[]{114.00192,22.52604});
        path.add(new double[]{114.00192,22.52604});
        path.add(new double[]{114.00288,22.5264});
        path.add(new double[]{114.00288,22.5264});
        path.add(new double[]{114.00336,22.52658});
        path.add(new double[]{114.00419,22.52682});
        path.add(new double[]{114.00511,22.52701});
        path.add(new double[]{114.00573,22.52709});
        path.add(new double[]{114.00649,22.52716});
        path.add(new double[]{114.00757,22.52716});
        path.add(new double[]{114.00862,22.52708});
        path.add(new double[]{114.00862,22.52708});
        path.add(new double[]{114.01145,22.52675});
        path.add(new double[]{114.01252,22.52668});
        path.add(new double[]{114.01341,22.5267});
        path.add(new double[]{114.01439,22.52681});
        path.add(new double[]{114.01439,22.52681});
        path.add(new double[]{114.01457,22.52684});
        path.add(new double[]{114.01457,22.52684});
        path.add(new double[]{114.01513,22.52693});
        path.add(new double[]{114.01513,22.52693});
        path.add(new double[]{114.01624,22.52715});
        path.add(new double[]{114.01624,22.52715});
        path.add(new double[]{114.01894,22.52779});
        path.add(new double[]{114.01894,22.52779});
        path.add(new double[]{114.01981,22.52798});
        path.add(new double[]{114.01981,22.52798});
        path.add(new double[]{114.0208,22.52821});
        path.add(new double[]{114.0208,22.52821});
        path.add(new double[]{114.02134,22.52833});
        path.add(new double[]{114.02134,22.52833});
        path.add(new double[]{114.02172,22.52844});
        path.add(new double[]{114.0224,22.52858});
        path.add(new double[]{114.0224,22.52858});
        path.add(new double[]{114.02492,22.52911});
        path.add(new double[]{114.02571,22.52917});
        path.add(new double[]{114.02571,22.52917});
        path.add(new double[]{114.02711,22.5291});
        path.add(new double[]{114.02711,22.5291});
        path.add(new double[]{114.02795,22.529});
        path.add(new double[]{114.02795,22.529});
        path.add(new double[]{114.02846,22.52888});
        path.add(new double[]{114.02846,22.52888});
        path.add(new double[]{114.02948,22.52864});
        path.add(new double[]{114.02948,22.52864});
        path.add(new double[]{114.03027,22.52842});
        path.add(new double[]{114.03376,22.52764});
        path.add(new double[]{114.03376,22.52764});
        path.add(new double[]{114.03444,22.52751});
        path.add(new double[]{114.03444,22.52751});
        path.add(new double[]{114.03549,22.52737});
        path.add(new double[]{114.03549,22.52737});
        path.add(new double[]{114.03592,22.52732});
        path.add(new double[]{114.03677,22.52729});
        path.add(new double[]{114.03677,22.52729});
        path.add(new double[]{114.03755,22.52728});
        path.add(new double[]{114.03755,22.52728});
        path.add(new double[]{114.03902,22.52737});
        path.add(new double[]{114.04047,22.52753});
        path.add(new double[]{114.04047,22.52753});
        path.add(new double[]{114.04196,22.5277});
        path.add(new double[]{114.04196,22.5277});
        path.add(new double[]{114.04421,22.52798});
        path.add(new double[]{114.04421,22.52798});
        path.add(new double[]{114.04488,22.52807});
        path.add(new double[]{114.04488,22.52807});
        path.add(new double[]{114.04752,22.52833});
        path.add(new double[]{114.04752,22.52833});
        path.add(new double[]{114.04965,22.52855});
        path.add(new double[]{114.05084,22.52858});
        path.add(new double[]{114.05084,22.52858});
        path.add(new double[]{114.05155,22.5286});
        path.add(new double[]{114.05155,22.5286});
        path.add(new double[]{114.0523,22.52861});
        path.add(new double[]{114.0523,22.52861});
        path.add(new double[]{114.054,22.52865});
        path.add(new double[]{114.054,22.52865});
        path.add(new double[]{114.05506,22.52866});
        path.add(new double[]{114.05506,22.52866});
        path.add(new double[]{114.05704,22.5287});
        path.add(new double[]{114.05704,22.5287});
        path.add(new double[]{114.06267,22.52881});
        path.add(new double[]{114.06267,22.52881});
        path.add(new double[]{114.06468,22.52885});
        path.add(new double[]{114.06468,22.52885});
        path.add(new double[]{114.06617,22.52886});
        path.add(new double[]{114.06617,22.52886});
        path.add(new double[]{114.06652,22.52886});
        path.add(new double[]{114.06652,22.52886});
        path.add(new double[]{114.06877,22.5289});
        path.add(new double[]{114.06877,22.5289});
        path.add(new double[]{114.07035,22.52893});
        path.add(new double[]{114.07035,22.52893});
        path.add(new double[]{114.07124,22.52896});
        path.add(new double[]{114.07124,22.52896});
        path.add(new double[]{114.07166,22.52895});
        path.add(new double[]{114.07166,22.52895});
        path.add(new double[]{114.07539,22.529});
        path.add(new double[]{114.07539,22.529});
        path.add(new double[]{114.07571,22.52901});
        path.add(new double[]{114.07571,22.52901});
        path.add(new double[]{114.07766,22.52904});
        path.add(new double[]{114.07766,22.52904});
        path.add(new double[]{114.07856,22.52905});
        path.add(new double[]{114.07856,22.52905});
        path.add(new double[]{114.08074,22.52909});
        path.add(new double[]{114.08074,22.52909});
        path.add(new double[]{114.08159,22.52912});
        path.add(new double[]{114.08159,22.52912});
        path.add(new double[]{114.08178,22.52914});
        path.add(new double[]{114.08199,22.52921});
        path.add(new double[]{114.0824,22.52942});
        path.add(new double[]{114.08267,22.52964});
        path.add(new double[]{114.08294,22.52998});
        path.add(new double[]{114.08294,22.52998});
        path.add(new double[]{114.08335,22.53067});
        path.add(new double[]{114.08411,22.53212});
        path.add(new double[]{114.08411,22.53212});
        path.add(new double[]{114.08462,22.53297});
        path.add(new double[]{114.08462,22.53297});
        path.add(new double[]{114.08471,22.5331});
        path.add(new double[]{114.08471,22.5331});
        path.add(new double[]{114.0851,22.53354});
        path.add(new double[]{114.08555,22.53391});
        path.add(new double[]{114.08555,22.53391});
        path.add(new double[]{114.08571,22.53402});
        path.add(new double[]{114.08622,22.53426});
        path.add(new double[]{114.08677,22.53446});
        path.add(new double[]{114.08677,22.53446});
        path.add(new double[]{114.08699,22.53452});
        path.add(new double[]{114.0875,22.53458});
        path.add(new double[]{114.0875,22.53458});
        path.add(new double[]{114.08887,22.53462});
        path.add(new double[]{114.08887,22.53462});
        path.add(new double[]{114.08917,22.53462});
        path.add(new double[]{114.08917,22.53462});
        path.add(new double[]{114.09176,22.53466});
        path.add(new double[]{114.09271,22.53471});
        path.add(new double[]{114.09271,22.53471});
        path.add(new double[]{114.09338,22.53479});
        path.add(new double[]{114.09338,22.53479});
        path.add(new double[]{114.09365,22.53483});
        path.add(new double[]{114.09365,22.53483});
        path.add(new double[]{114.09629,22.53534});
        path.add(new double[]{114.09629,22.53534});
        path.add(new double[]{114.09674,22.53538});
        path.add(new double[]{114.09674,22.53538});
        path.add(new double[]{114.1,22.53535});
        path.add(new double[]{114.1,22.53535});
        path.add(new double[]{114.10272,22.53538});
        path.add(new double[]{114.10272,22.53538});
        path.add(new double[]{114.10366,22.53539});
        path.add(new double[]{114.10366,22.53539});
        path.add(new double[]{114.10443,22.5354});
        path.add(new double[]{114.10443,22.5354});
        path.add(new double[]{114.10477,22.53541});
        path.add(new double[]{114.10477,22.53541});
        path.add(new double[]{114.10634,22.53543});
        path.add(new double[]{114.10634,22.53543});
        path.add(new double[]{114.1071,22.53544});
        path.add(new double[]{114.1071,22.53544});
        path.add(new double[]{114.10749,22.53545});
        path.add(new double[]{114.10749,22.53545});
        path.add(new double[]{114.10824,22.53544});
        path.add(new double[]{114.10824,22.53544});
        path.add(new double[]{114.1086,22.5354});
        path.add(new double[]{114.1086,22.5354});
        path.add(new double[]{114.10895,22.53533});
        path.add(new double[]{114.10941,22.53516});
        path.add(new double[]{114.10941,22.53516});
        path.add(new double[]{114.11011,22.53481});
        path.add(new double[]{114.11011,22.53481});
        path.add(new double[]{114.11022,22.53476});
        path.add(new double[]{114.11022,22.53476});
        path.add(new double[]{114.11036,22.53469});
        path.add(new double[]{114.11036,22.53469});
        path.add(new double[]{114.11065,22.53454});
        path.add(new double[]{114.11065,22.53454});
        path.add(new double[]{114.11104,22.53437});
        path.add(new double[]{114.11143,22.53428});
        path.add(new double[]{114.11143,22.53428});
        path.add(new double[]{114.1119,22.53428});
        path.add(new double[]{114.1119,22.53428});
        path.add(new double[]{114.11231,22.53435});
        path.add(new double[]{114.11406,22.53481});
        path.add(new double[]{114.11406,22.53481});
        path.add(new double[]{114.11471,22.53493});
        path.add(new double[]{114.11471,22.53493});
        path.add(new double[]{114.11521,22.535});
        path.add(new double[]{114.11521,22.535});
        path.add(new double[]{114.11639,22.53516});
        path.add(new double[]{114.11639,22.53516});
        path.add(new double[]{114.11703,22.53524});
        path.add(new double[]{114.1184,22.53549});
        path.add(new double[]{114.11925,22.53576});
        path.add(new double[]{114.11925,22.53576});
        path.add(new double[]{114.11988,22.53598});
        path.add(new double[]{114.11988,22.53598});
        path.add(new double[]{114.12031,22.53614});
        path.add(new double[]{114.12031,22.53614});
        path.add(new double[]{114.12067,22.53628});
        path.add(new double[]{114.12067,22.53628});
        path.add(new double[]{114.12146,22.53656});
        path.add(new double[]{114.12168,22.53657});
        path.add(new double[]{114.12187,22.53654});
        path.add(new double[]{114.12211,22.53638});
        path.add(new double[]{114.12246,22.53583});
        path.add(new double[]{114.12246,22.53583});
        path.add(new double[]{114.12283,22.53529});
        path.add(new double[]{114.12294,22.53518});
        path.add(new double[]{114.12294,22.53518});
        path.add(new double[]{114.12316,22.53502});
        path.add(new double[]{114.12316,22.53502});
        path.add(new double[]{114.12343,22.53492});
        path.add(new double[]{114.12379,22.53492});
        path.add(new double[]{114.12379,22.53492});
        path.add(new double[]{114.12408,22.53502});
        path.add(new double[]{114.12458,22.53534});
        path.add(new double[]{114.12458,22.53534});
        path.add(new double[]{114.125,22.53562});
        path.add(new double[]{114.125,22.53562});
        path.add(new double[]{114.12555,22.53598});
        path.add(new double[]{114.12555,22.53598});
        path.add(new double[]{114.12728,22.53709});
        path.add(new double[]{114.12728,22.53709});
        path.add(new double[]{114.12884,22.53815});
        path.add(new double[]{114.12884,22.53815});
        path.add(new double[]{114.12961,22.53865});
        path.add(new double[]{114.13104,22.53951});
        path.add(new double[]{114.13167,22.53984});
        path.add(new double[]{114.13167,22.53984});
        path.add(new double[]{114.13511,22.54162});
        path.add(new double[]{114.13511,22.54162});
        path.add(new double[]{114.13615,22.54216});
        path.add(new double[]{114.13615,22.54216});
        path.add(new double[]{114.13663,22.54242});
        path.add(new double[]{114.13663,22.54242});
        path.add(new double[]{114.13724,22.54274});
        path.add(new double[]{114.13724,22.54274});
        path.add(new double[]{114.13853,22.54347});
        path.add(new double[]{114.13853,22.54347});
        path.add(new double[]{114.1389,22.5437});
        path.add(new double[]{114.13926,22.54397});
        path.add(new double[]{114.13974,22.54447});
        path.add(new double[]{114.14019,22.54506});
        path.add(new double[]{114.14019,22.54506});
        path.add(new double[]{114.14069,22.54585});
        path.add(new double[]{114.14069,22.54585});
        path.add(new double[]{114.14164,22.54733});
        path.add(new double[]{114.14164,22.54733});
        path.add(new double[]{114.14221,22.54821});
        path.add(new double[]{114.14221,22.54821});
        path.add(new double[]{114.14253,22.54864});
        path.add(new double[]{114.14253,22.54864});
        path.add(new double[]{114.1435,22.55006});
        path.add(new double[]{114.1435,22.55006});
        path.add(new double[]{114.1438,22.55029});
        path.add(new double[]{114.1438,22.55029});
        path.add(new double[]{114.14392,22.55051});
        path.add(new double[]{114.14392,22.55051});
        path.add(new double[]{114.14422,22.55109});
        path.add(new double[]{114.14422,22.55109});
        path.add(new double[]{114.14433,22.55132});
        path.add(new double[]{114.14433,22.55132});
        path.add(new double[]{114.1445,22.55163});
        path.add(new double[]{114.14473,22.55185});
        path.add(new double[]{114.14628,22.55279});
        path.add(new double[]{114.14628,22.55279});
        path.add(new double[]{114.14653,22.55289});
        path.add(new double[]{114.14694,22.55294});
        path.add(new double[]{114.14694,22.55294});
        path.add(new double[]{114.14802,22.55282});
        path.add(new double[]{114.14802,22.55282});
        path.add(new double[]{114.14858,22.55271});
        path.add(new double[]{114.14858,22.55271});
        path.add(new double[]{114.14892,22.55267});
        path.add(new double[]{114.14892,22.55267});
        path.add(new double[]{114.149,22.55267});
        path.add(new double[]{114.149,22.55267});
        path.add(new double[]{114.14916,22.55266});
        path.add(new double[]{114.14916,22.55266});
        path.add(new double[]{114.14944,22.55263});
        path.add(new double[]{114.14944,22.55263});
        path.add(new double[]{114.14989,22.55259});
        path.add(new double[]{114.14989,22.55259});
        path.add(new double[]{114.15,22.55258});
        path.add(new double[]{114.15,22.55258});
        path.add(new double[]{114.1508,22.55255});
        path.add(new double[]{114.15104,22.55257});
        path.add(new double[]{114.15104,22.55257});
        path.add(new double[]{114.15158,22.55265});
        path.add(new double[]{114.15158,22.55265});
        path.add(new double[]{114.15166,22.55267});
        path.add(new double[]{114.15166,22.55267});
        path.add(new double[]{114.15254,22.55284});
        path.add(new double[]{114.15254,22.55284});
        path.add(new double[]{114.1552,22.55339});
        path.add(new double[]{114.1552,22.55339});
        path.add(new double[]{114.15543,22.55343});
        path.add(new double[]{114.15543,22.55343});
        path.add(new double[]{114.15547,22.55344});
        path.add(new double[]{114.15547,22.55344});
        path.add(new double[]{114.15567,22.55348});
        path.add(new double[]{114.15567,22.55348});
        path.add(new double[]{114.15583,22.55352});
        path.add(new double[]{114.15583,22.55352});
        path.add(new double[]{114.15611,22.55362});
        path.add(new double[]{114.15611,22.55362});
        path.add(new double[]{114.15632,22.5537});
        path.add(new double[]{114.15632,22.5537});
        path.add(new double[]{114.15674,22.55387});
        path.add(new double[]{114.15708,22.55405});
        path.add(new double[]{114.15708,22.55405});
        path.add(new double[]{114.15729,22.55417});
        path.add(new double[]{114.15729,22.55417});
        path.add(new double[]{114.15769,22.55447});
        path.add(new double[]{114.15769,22.55447});
        path.add(new double[]{114.15791,22.55464});
        path.add(new double[]{114.15791,22.55464});
        path.add(new double[]{114.15826,22.55492});
        path.add(new double[]{114.15826,22.55492});
        path.add(new double[]{114.15854,22.55514});
        path.add(new double[]{114.15854,22.55514});
        path.add(new double[]{114.15874,22.5553});
        path.add(new double[]{114.15874,22.5553});
        path.add(new double[]{114.15947,22.55588});
        path.add(new double[]{114.15947,22.55588});
        path.add(new double[]{114.16,22.5563});
        path.add(new double[]{114.16,22.5563});
        path.add(new double[]{114.16025,22.5565});
        path.add(new double[]{114.16025,22.5565});
        path.add(new double[]{114.1608,22.55693});
        path.add(new double[]{114.1608,22.55693});
        path.add(new double[]{114.16116,22.55721});
        path.add(new double[]{114.16116,22.55721});
        path.add(new double[]{114.16133,22.55735});
        path.add(new double[]{114.16133,22.55735});
        path.add(new double[]{114.16157,22.55754});
        path.add(new double[]{114.16157,22.55754});
        path.add(new double[]{114.16222,22.55803});
        path.add(new double[]{114.16222,22.55803});
        path.add(new double[]{114.16237,22.55813});
        path.add(new double[]{114.16237,22.55813});
        path.add(new double[]{114.16317,22.55856});
        path.add(new double[]{114.16317,22.55856});
        path.add(new double[]{114.1642,22.55901});
        path.add(new double[]{114.1642,22.55901});
        path.add(new double[]{114.16487,22.55928});
        path.add(new double[]{114.16487,22.55928});
        path.add(new double[]{114.16559,22.55957});
        path.add(new double[]{114.16559,22.55957});
        path.add(new double[]{114.16595,22.55972});
        path.add(new double[]{114.16671,22.55987});
        path.add(new double[]{114.16729,22.55991});
        path.add(new double[]{114.16908,22.55989});
        path.add(new double[]{114.16908,22.55989});
        path.add(new double[]{114.16972,22.5599});
        path.add(new double[]{114.16972,22.5599});
        path.add(new double[]{114.17111,22.55991});
        path.add(new double[]{114.17111,22.55991});
        path.add(new double[]{114.17256,22.55993});
        path.add(new double[]{114.17256,22.55993});
        path.add(new double[]{114.17332,22.55995});
        path.add(new double[]{114.17332,22.55995});
        path.add(new double[]{114.17507,22.55996});
        path.add(new double[]{114.17507,22.55996});
        path.add(new double[]{114.17583,22.55997});
        path.add(new double[]{114.17583,22.55997});
        path.add(new double[]{114.17608,22.55999});
        path.add(new double[]{114.17608,22.55999});
        path.add(new double[]{114.17649,22.56});
        path.add(new double[]{114.17649,22.56});
        path.add(new double[]{114.17709,22.55998});
        path.add(new double[]{114.17709,22.55998});
        path.add(new double[]{114.17747,22.55994});
        path.add(new double[]{114.17747,22.55994});
        path.add(new double[]{114.17802,22.55986});
        path.add(new double[]{114.17802,22.55986});
        path.add(new double[]{114.17868,22.55967});
        path.add(new double[]{114.17909,22.55951});
        path.add(new double[]{114.17909,22.55951});
        path.add(new double[]{114.17955,22.55932});
        path.add(new double[]{114.17955,22.55932});
        path.add(new double[]{114.17993,22.55911});
        path.add(new double[]{114.18084,22.55852});
        path.add(new double[]{114.18084,22.55852});
        path.add(new double[]{114.18112,22.55833});
        path.add(new double[]{114.18112,22.55833});
        path.add(new double[]{114.18145,22.55808});
        path.add(new double[]{114.18145,22.55808});
        path.add(new double[]{114.18254,22.55729});
        path.add(new double[]{114.18254,22.55729});
        path.add(new double[]{114.18342,22.55661});
        path.add(new double[]{114.18342,22.55661});
        path.add(new double[]{114.18367,22.55641});
        path.add(new double[]{114.18367,22.55641});
        path.add(new double[]{114.18511,22.55534});
        path.add(new double[]{114.18682,22.55414});
        path.add(new double[]{114.18682,22.55414});
        path.add(new double[]{114.18734,22.55384});
        path.add(new double[]{114.18734,22.55384});
        path.add(new double[]{114.18776,22.55369});
        path.add(new double[]{114.18807,22.55362});
        path.add(new double[]{114.18807,22.55362});
        path.add(new double[]{114.18931,22.55343});
        path.add(new double[]{114.18931,22.55343});
        path.add(new double[]{114.18962,22.5534});
        path.add(new double[]{114.18962,22.5534});
        path.add(new double[]{114.19038,22.55333});
        path.add(new double[]{114.19038,22.55333});
        path.add(new double[]{114.19199,22.55323});
        path.add(new double[]{114.19199,22.55323});
        path.add(new double[]{114.19277,22.55318});
        path.add(new double[]{114.19277,22.55318});
        path.add(new double[]{114.19429,22.55306});
        path.add(new double[]{114.19429,22.55306});
        path.add(new double[]{114.19509,22.55308});
        path.add(new double[]{114.19575,22.55318});
        path.add(new double[]{114.19575,22.55318});
        path.add(new double[]{114.19654,22.55342});
        path.add(new double[]{114.19654,22.55342});
        path.add(new double[]{114.19666,22.55344});
        path.add(new double[]{114.19666,22.55344});
        path.add(new double[]{114.19714,22.55355});
        path.add(new double[]{114.19714,22.55355});
        path.add(new double[]{114.19814,22.55383});
        path.add(new double[]{114.19814,22.55383});
        path.add(new double[]{114.20041,22.55444});
        path.add(new double[]{114.20184,22.55474});
        path.add(new double[]{114.20382,22.555});
        path.add(new double[]{114.20484,22.55509});
        path.add(new double[]{114.20662,22.5551});
        path.add(new double[]{114.20817,22.55506});
        path.add(new double[]{114.21119,22.55488});
        path.add(new double[]{114.21835,22.55452});
        path.add(new double[]{114.22026,22.55447});
        path.add(new double[]{114.22026,22.55447});
        path.add(new double[]{114.2207,22.55445});
        path.add(new double[]{114.2207,22.55445});
        path.add(new double[]{114.22079,22.55445});
        path.add(new double[]{114.22079,22.55445});
        path.add(new double[]{114.22155,22.55442});
        path.add(new double[]{114.22155,22.55442});
        path.add(new double[]{114.22204,22.5544});
        path.add(new double[]{114.22204,22.5544});
        path.add(new double[]{114.22248,22.55437});
        path.add(new double[]{114.22248,22.55437});
        path.add(new double[]{114.22253,22.55437});
        path.add(new double[]{114.22253,22.55437});
        path.add(new double[]{114.22351,22.55432});
        path.add(new double[]{114.22351,22.55432});
        path.add(new double[]{114.22362,22.55431});
        path.add(new double[]{114.22362,22.55431});
        path.add(new double[]{114.22427,22.55429});
        path.add(new double[]{114.22427,22.55429});
        path.add(new double[]{114.22443,22.55429});
        path.add(new double[]{114.22443,22.55429});
        path.add(new double[]{114.22481,22.55428});
        path.add(new double[]{114.22481,22.55428});
        path.add(new double[]{114.22673,22.55423});
        path.add(new double[]{114.22673,22.55423});
        path.add(new double[]{114.22691,22.55422});
        path.add(new double[]{114.22691,22.55422});
        path.add(new double[]{114.22716,22.5542});
        path.add(new double[]{114.22716,22.5542});
        path.add(new double[]{114.22768,22.55415});
        path.add(new double[]{114.22768,22.55415});
        path.add(new double[]{114.22824,22.55407});
        path.add(new double[]{114.22824,22.55407});
        path.add(new double[]{114.22853,22.55403});
        path.add(new double[]{114.22853,22.55403});
        path.add(new double[]{114.22865,22.55401});
        path.add(new double[]{114.22865,22.55401});
        path.add(new double[]{114.22893,22.55397});
        path.add(new double[]{114.22893,22.55397});
        path.add(new double[]{114.23053,22.55375});
        path.add(new double[]{114.23053,22.55375});
        path.add(new double[]{114.23062,22.55373});
        path.add(new double[]{114.23062,22.55373});
        path.add(new double[]{114.23221,22.55353});
        path.add(new double[]{114.23221,22.55353});
        path.add(new double[]{114.23295,22.55343});
        path.add(new double[]{114.23295,22.55343});
        path.add(new double[]{114.23361,22.55339});
        path.add(new double[]{114.23361,22.55339});
        path.add(new double[]{114.23387,22.55341});
        path.add(new double[]{114.23387,22.55341});
        path.add(new double[]{114.23411,22.55345});
        path.add(new double[]{114.23411,22.55345});
        path.add(new double[]{114.23423,22.55348});
        path.add(new double[]{114.23423,22.55348});
        path.add(new double[]{114.23458,22.55362});
        path.add(new double[]{114.23523,22.55401});
        path.add(new double[]{114.23523,22.55401});
        path.add(new double[]{114.23631,22.55462});
        path.add(new double[]{114.23631,22.55462});
        path.add(new double[]{114.23663,22.55481});
        path.add(new double[]{114.23663,22.55481});
        path.add(new double[]{114.23672,22.55487});
        path.add(new double[]{114.23672,22.55487});
        path.add(new double[]{114.23807,22.55571});
        path.add(new double[]{114.23807,22.55571});
        path.add(new double[]{114.23866,22.55606});
        path.add(new double[]{114.23866,22.55606});
        path.add(new double[]{114.23885,22.55617});
        path.add(new double[]{114.23885,22.55617});
        path.add(new double[]{114.23917,22.55636});
        path.add(new double[]{114.23917,22.55636});
        path.add(new double[]{114.23929,22.55642});
        path.add(new double[]{114.23929,22.55642});
        path.add(new double[]{114.23978,22.55683});
        path.add(new double[]{114.23978,22.55683});
        path.add(new double[]{114.24131,22.5584});
        path.add(new double[]{114.24131,22.5584});
        path.add(new double[]{114.24203,22.55912});
        path.add(new double[]{114.24203,22.55912});
        path.add(new double[]{114.24234,22.5594});
        path.add(new double[]{114.24267,22.5596});
        path.add(new double[]{114.24267,22.5596});
        path.add(new double[]{114.24296,22.55975});
        path.add(new double[]{114.24296,22.55975});
        path.add(new double[]{114.24303,22.55978});
        path.add(new double[]{114.24303,22.55978});
        path.add(new double[]{114.24516,22.56076});
        path.add(new double[]{114.24516,22.56076});
        path.add(new double[]{114.24542,22.5609});
        path.add(new double[]{114.24542,22.5609});
        path.add(new double[]{114.24567,22.56107});
        path.add(new double[]{114.24567,22.56107});
        path.add(new double[]{114.24577,22.56116});
        path.add(new double[]{114.24577,22.56116});
        path.add(new double[]{114.24594,22.56131});
        path.add(new double[]{114.24594,22.56131});
        path.add(new double[]{114.246,22.56137});
        path.add(new double[]{114.246,22.56137});
        path.add(new double[]{114.24629,22.56173});
        path.add(new double[]{114.24689,22.56236});
        path.add(new double[]{114.24689,22.56236});
        path.add(new double[]{114.24745,22.56298});
        path.add(new double[]{114.24745,22.56298});
        path.add(new double[]{114.24754,22.56308});
        path.add(new double[]{114.24754,22.56308});
        path.add(new double[]{114.24778,22.56328});
        path.add(new double[]{114.24778,22.56328});
        path.add(new double[]{114.24816,22.56364});
        path.add(new double[]{114.24816,22.56364});
        path.add(new double[]{114.24832,22.56379});
        path.add(new double[]{114.24832,22.56379});
        path.add(new double[]{114.24945,22.56486});
        path.add(new double[]{114.24945,22.56486});
        path.add(new double[]{114.24966,22.56505});
        path.add(new double[]{114.24966,22.56505});
        path.add(new double[]{114.25,22.56536});
        path.add(new double[]{114.25,22.56536});
        path.add(new double[]{114.25086,22.56614});
        path.add(new double[]{114.25145,22.56672});
        path.add(new double[]{114.25173,22.56708});
        path.add(new double[]{114.25238,22.56817});
        path.add(new double[]{114.25238,22.56817});
        path.add(new double[]{114.25245,22.56827});
        path.add(new double[]{114.25245,22.56827});
        path.add(new double[]{114.25257,22.56847});
        path.add(new double[]{114.25257,22.56847});
        path.add(new double[]{114.25263,22.56856});
        path.add(new double[]{114.25263,22.56856});
        path.add(new double[]{114.25276,22.56874});
        path.add(new double[]{114.25276,22.56874});
        path.add(new double[]{114.25295,22.56887});
        path.add(new double[]{114.25304,22.56898});
        path.add(new double[]{114.25304,22.56898});
        path.add(new double[]{114.25342,22.5694});
        path.add(new double[]{114.25342,22.5694});
        path.add(new double[]{114.25375,22.56977});
        path.add(new double[]{114.25375,22.56977});
        path.add(new double[]{114.25385,22.56989});
        path.add(new double[]{114.25385,22.56989});
        path.add(new double[]{114.25518,22.57141});
        path.add(new double[]{114.25518,22.57141});
        path.add(new double[]{114.25601,22.57226});
        path.add(new double[]{114.25601,22.57226});
        path.add(new double[]{114.25616,22.57229});
        path.add(new double[]{114.25616,22.57229});
        path.add(new double[]{114.25645,22.57241});
        path.add(new double[]{114.25657,22.57258});
        path.add(new double[]{114.25657,22.57258});
        path.add(new double[]{114.25659,22.57267});
        path.add(new double[]{114.25659,22.57267});
        path.add(new double[]{114.25784,22.57368});
        path.add(new double[]{114.25784,22.57368});
        path.add(new double[]{114.25851,22.57422});
        path.add(new double[]{114.25851,22.57422});
        path.add(new double[]{114.25855,22.57446});
        path.add(new double[]{114.25855,22.57446});
        path.add(new double[]{114.25887,22.57469});
        path.add(new double[]{114.25887,22.57469});
        path.add(new double[]{114.25911,22.57485});
        path.add(new double[]{114.25911,22.57485});
        path.add(new double[]{114.26051,22.57603});
        path.add(new double[]{114.26051,22.57603});
        path.add(new double[]{114.26066,22.57618});
        path.add(new double[]{114.26066,22.57618});
        path.add(new double[]{114.2608,22.5763});
        path.add(new double[]{114.2608,22.5763});
        path.add(new double[]{114.26152,22.57687});
        path.add(new double[]{114.26152,22.57687});
        path.add(new double[]{114.26266,22.57779});
        path.add(new double[]{114.26266,22.57779});
        path.add(new double[]{114.26289,22.57797});
        path.add(new double[]{114.26289,22.57797});
        path.add(new double[]{114.26352,22.57847});
        path.add(new double[]{114.26352,22.57847});
        path.add(new double[]{114.2638,22.5787});
        path.add(new double[]{114.2638,22.5787});
        path.add(new double[]{114.26414,22.57898});
        path.add(new double[]{114.26414,22.57898});
        path.add(new double[]{114.26488,22.57953});
        path.add(new double[]{114.26615,22.58057});
        path.add(new double[]{114.26615,22.58057});
        path.add(new double[]{114.26643,22.58082});
        path.add(new double[]{114.26643,22.58082});
        path.add(new double[]{114.26664,22.581});
        path.add(new double[]{114.26664,22.581});
        path.add(new double[]{114.26713,22.58152});
        path.add(new double[]{114.26742,22.58189});
        path.add(new double[]{114.26742,22.58189});
        path.add(new double[]{114.26768,22.58223});
        path.add(new double[]{114.26768,22.58223});
        path.add(new double[]{114.26796,22.5826});
        path.add(new double[]{114.26796,22.5826});
        path.add(new double[]{114.2684,22.58323});
        path.add(new double[]{114.2684,22.58323});
        path.add(new double[]{114.26848,22.58333});
        path.add(new double[]{114.26848,22.58333});
        path.add(new double[]{114.26853,22.5834});
        path.add(new double[]{114.26853,22.5834});
        path.add(new double[]{114.26878,22.58372});
        path.add(new double[]{114.26878,22.58372});
        path.add(new double[]{114.26893,22.58393});
        path.add(new double[]{114.26893,22.58393});
        path.add(new double[]{114.26927,22.58438});
        path.add(new double[]{114.26927,22.58438});
        path.add(new double[]{114.26947,22.58461});
        path.add(new double[]{114.26947,22.58461});
        path.add(new double[]{114.2695,22.5846});
        path.add(new double[]{114.2695,22.5846});
        path.add(new double[]{114.26975,22.58489});
        path.add(new double[]{114.26975,22.58489});
        path.add(new double[]{114.27,22.58514});
        path.add(new double[]{114.27,22.58514});
        path.add(new double[]{114.27015,22.58529});
        path.add(new double[]{114.27015,22.58529});
        path.add(new double[]{114.2706,22.58585});
        path.add(new double[]{114.2706,22.58585});
        path.add(new double[]{114.27081,22.58609});
        path.add(new double[]{114.27105,22.58626});
        path.add(new double[]{114.27105,22.58626});
        path.add(new double[]{114.27184,22.58682});
        path.add(new double[]{114.27184,22.58682});
        path.add(new double[]{114.27203,22.58693});
        path.add(new double[]{114.27203,22.58693});
        path.add(new double[]{114.2726,22.58724});
        path.add(new double[]{114.2726,22.58724});
        path.add(new double[]{114.2728,22.58736});
        path.add(new double[]{114.2728,22.58736});
        path.add(new double[]{114.27301,22.58746});
        path.add(new double[]{114.27301,22.58746});
        path.add(new double[]{114.2733,22.58755});
        path.add(new double[]{114.2733,22.58755});
        path.add(new double[]{114.27345,22.58759});
        path.add(new double[]{114.27345,22.58759});
        path.add(new double[]{114.27366,22.5876});
        path.add(new double[]{114.27366,22.5876});
        path.add(new double[]{114.27401,22.58762});
        path.add(new double[]{114.27401,22.58762});
        path.add(new double[]{114.27461,22.58749});
        path.add(new double[]{114.27487,22.58739});
        path.add(new double[]{114.27487,22.58739});
        path.add(new double[]{114.27487,22.58746});
        path.add(new double[]{114.27487,22.58746});
        path.add(new double[]{114.2749,22.58765});
        path.add(new double[]{114.27494,22.58772});
        path.add(new double[]{114.27494,22.58772});
        path.add(new double[]{114.27504,22.58772});
        path.add(new double[]{114.27504,22.58772});
        path.add(new double[]{114.27527,22.5878});
        path.add(new double[]{114.27527,22.5878});
        path.add(new double[]{114.27551,22.58786});
        path.add(new double[]{114.27551,22.58786});
        path.add(new double[]{114.27674,22.58788});
        path.add(new double[]{114.27809,22.58766});
        path.add(new double[]{114.27809,22.58766});
        path.add(new double[]{114.27851,22.58763});
        path.add(new double[]{114.27851,22.58763});
        path.add(new double[]{114.27878,22.58761});
        path.add(new double[]{114.27878,22.58761});
        path.add(new double[]{114.27912,22.58757});
        path.add(new double[]{114.27912,22.58757});
        path.add(new double[]{114.27941,22.58752});
        path.add(new double[]{114.2796,22.58741});
        path.add(new double[]{114.2796,22.58741});
        path.add(new double[]{114.27967,22.58737});
        path.add(new double[]{114.27967,22.58737});
        path.add(new double[]{114.27998,22.5871});
        path.add(new double[]{114.27998,22.5871});
        path.add(new double[]{114.28025,22.58687});
        path.add(new double[]{114.28025,22.58687});
        path.add(new double[]{114.28108,22.58671});
        path.add(new double[]{114.28141,22.58659});
        path.add(new double[]{114.28169,22.58653});
        path.add(new double[]{114.28351,22.58651});
        path.add(new double[]{114.28351,22.58651});
        path.add(new double[]{114.28421,22.58649});
        path.add(new double[]{114.28421,22.58649});
        path.add(new double[]{114.28468,22.58649});
        path.add(new double[]{114.28468,22.58649});
        path.add(new double[]{114.28551,22.58648});
        path.add(new double[]{114.28551,22.58648});
        path.add(new double[]{114.28593,22.5866});
        path.add(new double[]{114.28593,22.5866});
        path.add(new double[]{114.28631,22.58677});
        path.add(new double[]{114.28659,22.58683});
        path.add(new double[]{114.28696,22.58684});
        path.add(new double[]{114.28696,22.58684});
        path.add(new double[]{114.28703,22.58684});
        path.add(new double[]{114.28703,22.58684});
        path.add(new double[]{114.28756,22.58687});
        path.add(new double[]{114.28792,22.58678});
        path.add(new double[]{114.28902,22.58618});
        path.add(new double[]{114.28942,22.58603});
        path.add(new double[]{114.28942,22.58603});
        path.add(new double[]{114.29,22.58598});
        path.add(new double[]{114.29077,22.58586});
        path.add(new double[]{114.29077,22.58586});
        path.add(new double[]{114.29134,22.5857});
        path.add(new double[]{114.29163,22.58552});
        path.add(new double[]{114.29179,22.58533});
        path.add(new double[]{114.29179,22.58533});
        path.add(new double[]{114.29195,22.58514});
        path.add(new double[]{114.29221,22.58495});
        path.add(new double[]{114.29221,22.58495});
        path.add(new double[]{114.29239,22.58481});
        path.add(new double[]{114.29283,22.58467});
        path.add(new double[]{114.29323,22.58462});
        path.add(new double[]{114.29323,22.58462});
        path.add(new double[]{114.29342,22.5846});
        path.add(new double[]{114.29476,22.5842});
        path.add(new double[]{114.29476,22.5842});
        path.add(new double[]{114.29607,22.58387});
        path.add(new double[]{114.29607,22.58387});
        path.add(new double[]{114.2963,22.58383});
        path.add(new double[]{114.29681,22.58381});
        path.add(new double[]{114.29717,22.58368});
        path.add(new double[]{114.29759,22.58333});
        path.add(new double[]{114.29759,22.58333});
        path.add(new double[]{114.29771,22.58323});
        path.add(new double[]{114.29771,22.58323});
        path.add(new double[]{114.29796,22.58303});
        path.add(new double[]{114.29796,22.58303});
        path.add(new double[]{114.29822,22.58282});
        path.add(new double[]{114.29848,22.58268});
        path.add(new double[]{114.29869,22.58267});
        path.add(new double[]{114.29891,22.58279});
        path.add(new double[]{114.29925,22.58312});
        path.add(new double[]{114.29952,22.58324});
        path.add(new double[]{114.29999,22.58333});
        path.add(new double[]{114.29999,22.58333});
        path.add(new double[]{114.30015,22.58336});
        path.add(new double[]{114.30031,22.58333});
        path.add(new double[]{114.30031,22.58333});
        path.add(new double[]{114.30084,22.58316});
        path.add(new double[]{114.30084,22.58316});
        path.add(new double[]{114.30174,22.58286});
        path.add(new double[]{114.30205,22.58286});
        path.add(new double[]{114.30244,22.58291});
        path.add(new double[]{114.30289,22.58279});
        path.add(new double[]{114.3033,22.5826});
        path.add(new double[]{114.30358,22.58234});
        path.add(new double[]{114.30358,22.58234});
        path.add(new double[]{114.30364,22.58229});
        path.add(new double[]{114.30394,22.58219});
        path.add(new double[]{114.30463,22.58217});
        path.add(new double[]{114.3048,22.58214});
        path.add(new double[]{114.3048,22.58214});
        path.add(new double[]{114.30498,22.5821});
        path.add(new double[]{114.30498,22.5821});
        path.add(new double[]{114.30562,22.58199});
        path.add(new double[]{114.30579,22.58203});
        path.add(new double[]{114.30579,22.58203});
        path.add(new double[]{114.30588,22.58206});
        path.add(new double[]{114.30603,22.58222});
        path.add(new double[]{114.30607,22.58245});
        path.add(new double[]{114.30605,22.58265});
        path.add(new double[]{114.30605,22.58265});
        path.add(new double[]{114.30602,22.58291});
        path.add(new double[]{114.30602,22.58291});
        path.add(new double[]{114.306,22.58333});
        path.add(new double[]{114.306,22.58333});
        path.add(new double[]{114.30606,22.58349});
        path.add(new double[]{114.30616,22.58364});
        path.add(new double[]{114.30617,22.5839});
        path.add(new double[]{114.30609,22.58412});
        path.add(new double[]{114.30575,22.58432});
        path.add(new double[]{114.30575,22.58432});
        path.add(new double[]{114.30552,22.58442});
        path.add(new double[]{114.30516,22.58493});
        path.add(new double[]{114.30516,22.58493});
        path.add(new double[]{114.30493,22.58551});
        path.add(new double[]{114.30442,22.58591});
        path.add(new double[]{114.30442,22.58591});
        path.add(new double[]{114.30401,22.58621});
        path.add(new double[]{114.30401,22.58621});
        path.add(new double[]{114.30391,22.58637});
        path.add(new double[]{114.30388,22.58652});
        path.add(new double[]{114.30389,22.58735});
        path.add(new double[]{114.30382,22.58777});
        path.add(new double[]{114.30382,22.58777});
        path.add(new double[]{114.30375,22.5882});
        path.add(new double[]{114.30378,22.58853});
        path.add(new double[]{114.30391,22.58911});
        path.add(new double[]{114.30391,22.58911});
        path.add(new double[]{114.30403,22.58942});
        path.add(new double[]{114.30431,22.5897});
        path.add(new double[]{114.30431,22.5897});
        path.add(new double[]{114.3045,22.58985});
        path.add(new double[]{114.3045,22.58985});
        path.add(new double[]{114.30487,22.59012});
        path.add(new double[]{114.30487,22.59012});
        path.add(new double[]{114.30509,22.59032});
        path.add(new double[]{114.30509,22.59032});
        path.add(new double[]{114.30533,22.59069});
        path.add(new double[]{114.30533,22.59069});
        path.add(new double[]{114.3054,22.5908});
        path.add(new double[]{114.3054,22.5908});
        path.add(new double[]{114.30573,22.59145});
        path.add(new double[]{114.30573,22.59145});
        path.add(new double[]{114.30579,22.59156});
        path.add(new double[]{114.30579,22.59156});
        path.add(new double[]{114.30582,22.59164});
        path.add(new double[]{114.30582,22.59164});
        path.add(new double[]{114.30593,22.59187});
        path.add(new double[]{114.30593,22.59187});
        path.add(new double[]{114.30605,22.59213});
        path.add(new double[]{114.30654,22.59281});
        path.add(new double[]{114.30654,22.59281});
        path.add(new double[]{114.30725,22.5935});
        path.add(new double[]{114.30799,22.59407});
        path.add(new double[]{114.30843,22.5945});
        path.add(new double[]{114.30843,22.5945});
        path.add(new double[]{114.30868,22.59476});
        path.add(new double[]{114.30868,22.59476});
        path.add(new double[]{114.30923,22.59538});
        path.add(new double[]{114.30923,22.59538});
        path.add(new double[]{114.3094,22.59563});
        path.add(new double[]{114.3094,22.59563});
        path.add(new double[]{114.31044,22.59712});
        path.add(new double[]{114.31092,22.59761});
        path.add(new double[]{114.31121,22.59786});
        path.add(new double[]{114.31121,22.59786});
        path.add(new double[]{114.31145,22.59804});
        path.add(new double[]{114.31145,22.59804});
        path.add(new double[]{114.31156,22.5981});
        path.add(new double[]{114.31156,22.5981});
        path.add(new double[]{114.31147,22.59818});
        path.add(new double[]{114.31147,22.59818});
        path.add(new double[]{114.31119,22.59842});
        path.add(new double[]{114.31119,22.59842});
        path.add(new double[]{114.31089,22.59865});
        path.add(new double[]{114.31089,22.59865});
        path.add(new double[]{114.31071,22.59881});
        path.add(new double[]{114.31071,22.59881});
        path.add(new double[]{114.31065,22.59885});
        path.add(new double[]{114.31065,22.59885});
        path.add(new double[]{114.31051,22.59897});
        path.add(new double[]{114.31051,22.59897});
        path.add(new double[]{114.31039,22.59907});


//        path.add(new double[] {113.95398, 22.53655});
//        path.add(new double[] {113.95399, 22.5364});
//        path.add(new double[] {113.95399, 22.5364});
//        path.add(new double[] {113.95399, 22.53632});
//        path.add(new double[] {113.95399, 22.53632});
//        path.add(new double[] {113.95403, 22.53631});
//        path.add(new double[] {113.95403, 22.53631});
//        path.add(new double[] {113.95403, 22.5364});
//        path.add(new double[] {113.95403, 22.5364});
//        path.add(new double[] {113.95402, 22.53665});
//        path.add(new double[] {113.95402, 22.53665});
//        path.add(new double[] {113.95401, 22.53684});
//        path.add(new double[] {113.95401, 22.53684});
//        path.add(new double[] {113.954, 22.53713});
//        path.add(new double[] {113.954, 22.53713});
//        path.add(new double[] {113.954, 22.53721});
//        path.add(new double[] {113.954, 22.53721});
//        path.add(new double[] {113.95399, 22.53752});
//        path.add(new double[] {113.95399, 22.53752});
//        path.add(new double[] {113.95398, 22.53776});
//        path.add(new double[] {113.95398, 22.53776});
//        path.add(new double[] {113.95398, 22.53829});
//        path.add(new double[] {113.95398, 22.53829});
//        path.add(new double[] {113.95397, 22.53888});
//        path.add(new double[] {113.95397, 22.53888});
//        path.add(new double[] {113.95395, 22.53895});
//        path.add(new double[] {113.95395, 22.53895});
//        path.add(new double[] {113.95396, 22.5392});
//        path.add(new double[] {113.95396, 22.5392});
//        path.add(new double[] {113.95396, 22.53938});
//        path.add(new double[] {113.95396, 22.53938});
//        path.add(new double[] {113.95395, 22.53965});
//        path.add(new double[] {113.95395, 22.53965});
//        path.add(new double[] {113.95394, 22.53987});
//        path.add(new double[] {113.95394, 22.53987});
//        path.add(new double[] {113.95393, 22.54012});
//        path.add(new double[] {113.95393, 22.54012});
//        path.add(new double[] {113.95394, 22.54038});
//        path.add(new double[] {113.95394, 22.54038});
//        path.add(new double[] {113.95386, 22.54038});
//        path.add(new double[] {113.95386, 22.54038});
//        path.add(new double[] {113.95357, 22.54036});
//        path.add(new double[] {113.95357, 22.54036});
//        path.add(new double[] {113.95329, 22.54035});
//        path.add(new double[] {113.95329, 22.54035});
//        path.add(new double[] {113.95295, 22.54034});
//        path.add(new double[] {113.95295, 22.54034});
//        path.add(new double[] {113.95225, 22.54031});
//        path.add(new double[] {113.95225, 22.54031});
//        path.add(new double[] {113.95198, 22.5403});
//        path.add(new double[] {113.95198, 22.5403});
//        path.add(new double[] {113.95171, 22.54028});
//        path.add(new double[] {113.95171, 22.54028});
//        path.add(new double[] {113.95131, 22.54026});
//        path.add(new double[] {113.95131, 22.54026});
//        path.add(new double[] {113.94914, 22.54016});
//        path.add(new double[] {113.94914, 22.54016});
//        path.add(new double[] {113.94805, 22.54012});
//        path.add(new double[] {113.94805, 22.54012});
//        path.add(new double[] {113.94786, 22.54009});
//        path.add(new double[] {113.94786, 22.54009});
//        path.add(new double[] {113.94742, 22.54008});
//        path.add(new double[] {113.94742, 22.54008});
//        path.add(new double[] {113.94695, 22.54006});
//        path.add(new double[] {113.94695, 22.54006});
//        path.add(new double[] {113.9463, 22.54003});
//        path.add(new double[] {113.9463, 22.54003});
//        path.add(new double[] {113.94578, 22.54001});
//        path.add(new double[] {113.94578, 22.54001});
//        path.add(new double[] {113.94552, 22.54});
//        path.add(new double[] {113.94552, 22.54});
//        path.add(new double[] {113.94532, 22.53999});
//        path.add(new double[] {113.94532, 22.53999});
//        path.add(new double[] {113.94465, 22.53995});
//        path.add(new double[] {113.94465, 22.53995});
//        path.add(new double[] {113.94331, 22.53989});
//        path.add(new double[] {113.94331, 22.53989});
//        path.add(new double[] {113.94285, 22.53996});

    }

    private Routine routine;


    @Override
    protected void onStart() {
        super.onStart();

        filterDuplicatedPoints(path);

        routine = new Routine();


        mGlSurfaceView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mGlSurfaceView.requestRender();

                if (currPosition < path.size() - 10) {
                    mGlSurfaceView.postDelayed(this, 500);
                }
            }
        }, 500);
    }

//    private int currPosition = 9;
    private int currPosition = 0;
    private float[] points;
    @Override
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);

        gl.glLoadIdentity();

//        if (currPosition + 10 >= path.size()) {
//            return;
//        }
        points = routeMapToCoordinates(path.subList(currPosition, currPosition +6));
//        points = mapToCoordinatesInserted(path.subList(currPosition, currPosition +6));
//        points = mapToCoordinatesInserted(path.subList(currPosition, currPosition +6));
//        points = new float[] {
//                0,0,0,
//                0.1f,0.1f,0,
//                0.2f,0.2f,0,
//                0.3f,0.3f,0,
//                0.4f,0.4f,0,
//                0.5f,0.5f,0,
//                0.6f,0.6f,0,
//                0.7f,0.7f,0,
//                0.8f,0.8f,0,
//                0.9f,0.9f,0
//
//        };


        routine.setPath(points);
//        printArray(points, 3);
        antiSmooth(gl);

        float[] eyePosition = {points[0],points[1], (float) EyeHeight};
        float[] target = {points[3],points[4],0};
//        float[] eyePosition = {points[3] - 0.2f,points[4]-0.2f, 0.2f};

        target = calculateEyeTargetPosition(target[0], target[1]);

//        double mo = Math.sqrt(points[3] * points[3] + points[4] * points[4]);
//        float[] target = {points[currPosition+3], points[currPosition+4], 0};

        Log.e("sss", String.format("look at:%f,%f,%f --->%f,%f,%f", eyePosition[0], eyePosition[1], target[2],
                target[0], target[1],target[2]));

        GLU.gluLookAt(gl,
                eyePosition[0],eyePosition[1], target[2],
//                (eyePosition[0] +target[0])/2,(eyePosition[1]+target[1])/2, 0,
                target[0],target[1],0,
                0,0,1);


        gl.glPushMatrix();
        gl.glTranslatef(-0.1f, -0.1f, 0);
        routine.draw(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.1f, 0.1f, 0);
        routine.draw(gl);
        gl.glPopMatrix();


        currPosition+=3;
    }


    private static final double EyeDistance = 1f;
    private static final double EyeHeight = 0.3f;

    private float[] calculateEyePosition(double targetX, double targetY) {
        return null;
    }

    //not working
    private float[] calculateEyeTargetPosition(double targetX, double targetY) {
        double x = 0;
        double y = 0;

        //targetX ==0
        if (targetX == 0) {
            //look at +y

            x = 0;
            y = Math.sqrt(Math.pow(EyeDistance, 2) - Math.pow(EyeHeight, 2));
            y *= targetY/Math.abs(targetY);
        }else if (targetY == 0) {
            y = 0;
            x = Math.sqrt(Math.pow(EyeDistance, 2) - Math.pow(EyeHeight, 2));
            x *= targetX/Math.abs(targetX);

        }else {
            double aabb = Math.pow(targetX, 2) + Math.pow(targetY, 2);
            double upValue = Math.pow(targetX, 2) * (Math.pow(EyeDistance, 2) - Math.pow(EyeHeight, 2));
            x = Math.sqrt(upValue / aabb);
            //确定 x 符号
            x *= targetX/Math.abs(targetX);
            y = x * targetY / targetX;
        }

        double oldDis = Math.sqrt(Math.pow(targetX, 2) + Math.pow(targetY, 2));
        double newDis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

//        float height = (float) (EyeHeight * (oldDis/newDis));
        float height = (float) (oldDis / 3.14);

        Log.e("sss", "next Point:" +targetX +", " +targetY + ", dis:"+oldDis);
        Log.e("sss", "calu target:" +x +", " +y + ", dis:"+newDis);
        Log.e("sss", "eyeDistance:" +Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(EyeHeight, 2)));


        return new float[]{(float) x, (float) y, height};
    }

    private float[] routeMapToCoordinates(final List<double[]> route) {
        float[] points = new float[route.size() * 3];

        int idx = 0;
        double[] origin = route.get(0);
        for (double[] point : route) {
            points[idx++] = (float) (point[0] - origin[0]) * 10000;
            points[idx++] = (float) (point[1] - origin[1]) * 10000;
            points[idx++] = 0f;
        }
//        printArray(points, 3);
        return points;
    }

    private float[] mapToCoordinatesInserted(final List<double[]> route) {
        List<double[]> inserted = new ArrayList<>();

        double[] first;
        double[] second;
        for (int idx = 0; idx < route.size() -2; idx ++) {
            first = route.get(idx);
            second = route.get(idx+1);
            inserted.addAll(routePointInsert(first, second));
        }
        filterDuplicatedPoints(inserted);
        return routeMapToCoordinates(inserted);
    }

    private List<double[]> routePointInsert(double[] first, double[] second) {
        double distance = getDisanceBetweenPoints(first, second);

        List<double[]> routePoints = new ArrayList<>();

        if (distance > 5) {
            int count = (int) Math.ceil(distance / 5);
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

    private double getDisanceBetweenPoints(double[] first, double[] second) {
        double distance = Util.getrelativeDistance(first[0], first[1], second[0], second[1]);
        return distance;
    }

    private void filterDuplicatedPoints(List<double[]> path) {

//        printAllPoints();
        List<double[]> deleted = new ArrayList<>();
        double[] first;
        double[] second;

        for (int i=1; i<path.size(); i++) {
            first = path.get(i-1);
            second = path.get(i);
            if (Math.abs(first[0] - second[0]) < Double.MIN_VALUE
                    && Math.abs(first[1] - second[1]) < Double.MIN_VALUE) {
//                path.remove(i);
                deleted.add(path.get(i));
            }
        }
        path.removeAll(deleted);
        Log.e("sssss ", "--------------------------------------------------------------------------");
//        printAllPoints();
    }

    private void printArray(float[] data, int unitSize) {
        System.out.println("print array:");

        for (int i=0; i< data.length; i++) {
            System.out.print(" "+ data[i]);
            if ((i + 1) % unitSize == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
