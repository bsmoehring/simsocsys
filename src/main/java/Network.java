import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laemmel on 27.04.17.
 */
public class Network {
    
	private final Map<Integer,Node> nodes = new HashMap<Integer,Node>();
	private final Map<Integer,Link> links = new HashMap<Integer,Link>();
	private final List<LinkInfo> linkInfos = new ArrayList<>();

	public Network(){
		Node n1 = createNode	(02.205, 01.00, 1);
		Node n2 = createNode	(02.855, 01.00, 2);
//        Node n3 = createNode(02.53, 01.50, 3);
        Node n4 = createNode	(02.205, 01.825, 4);
        Node n5 = createNode	(02.855, 01.825, 5);
        Node n6 = createNode	(01.88, 02.15, 6);
        Node n7 = createNode	(02.53, 02.80, 7);
        Node n8 = createNode	(02.53, 03.30, 8);
        Node n9 = createNode	(03.18, 02.15, 9);
        Node n10 = createNode	(02.205, -9.00, 10);
        Node n11 = createNode	(02.855, -9.00, 11);
        Node n12 = createNode	(02.205, 0.50, 12);
        Node n13 = createNode	(02.855, 0.50, 13);
        Node n14 = createNode	(01.00, 02.15, 14);
        Node n20 = createNode	(01.00, 0.50, 20);

        Node n15 = createNode	(04.06, 0.50, 15);   
        Node n16 = createNode	(04.95, 0.50, 16);
        Node n17 = createNode	(04.06, 02.15, 17);   
        Node n18 = createNode	(04.95, 02.15, 18);
        
		Node n41 = createNode	(06.125, 01.00, 41);
		Node n42 = createNode	(06.775, 01.00, 42);
//        Node n43 = createNode(06.45, 01.50, 43);
        Node n44 = createNode	(06.125, 01.825, 44);
        Node n45 = createNode	(06.775, 01.825, 45);
        Node n46 = createNode	(05.8, 02.15, 46);
        Node n47 = createNode	(06.45, 02.80, 47);
        Node n48 = createNode	(06.45, 03.30, 48);
        Node n49 = createNode	(07.1, 02.15, 49);
        Node n410 = createNode	(06.125, -9.00, 410);
        Node n411 = createNode	(06.775, -9.00, 411);
        Node n412 = createNode	(06.125, 0.50, 412);
        Node n413 = createNode	(06.775, 0.50, 413);
//        Node n414 = createNode	(04.92, 02.15, 414);
        
        Node n915 = createNode	(07.98, 0.50, 915);   
        Node n916 = createNode	(08.87, 0.50, 916);
        Node n917 = createNode	(07.98, 02.15, 917);   
        Node n918 = createNode	(08.87, 02.15, 918);
        
        Node n51 = createNode	(10.045, 01.00, 51);
		Node n52 = createNode	(10.695, 01.00, 52);
//        Node n53 = createNode	(10.37, 01.50, 53);
        Node n54 = createNode	(10.045, 01.825, 54);
        Node n55 = createNode	(10.695, 01.825, 55);
        Node n56 = createNode	(09.72, 02.15, 56);
        Node n57 = createNode	(10.37, 02.80, 57);
        Node n58 = createNode	(10.37, 03.30, 58);
        Node n59 = createNode	(11.02, 02.15, 59);
        Node n510 = createNode	(10.045, -9.00, 510);
        Node n511 = createNode	(10.695, -9.00, 511);
        Node n512 = createNode(10.045, 0.50, 512);
        Node n513 = createNode(10.695, 0.50, 513);
//        Node n514 = createNode(08.84, 02.15, 514);
        
        Node n1015 = createNode(11.90, 0.50, 1015);   
        Node n1016 = createNode(12.79, 0.50, 1016);
        Node n1017 = createNode(11.90, 02.15, 1017);   
        Node n1018 = createNode(12.79, 02.15, 1018);
        
        Node n61 = createNode(13.965, 01.00, 61);
		Node n62 = createNode(14.615, 01.00, 62);
//        Node n63 = createNode(14.29, 01.50, 63);
        Node n64 = createNode(13.965, 01.825, 64);
        Node n65 = createNode(14.615, 01.825, 65);
        Node n66 = createNode(13.64, 02.15, 66);
        Node n67 = createNode(14.29, 02.80, 67);
        Node n68 = createNode(14.29, 03.30, 68);
        Node n69 = createNode(14.94, 02.15, 69);
        Node n610 = createNode(13.965, -9.00, 610);
        Node n611 = createNode(14.615, -9.00, 611);
        Node n612 = createNode(13.965, 0.50, 612);
        Node n613 = createNode(14.615, 0.50, 613);
//        Node n614 = createNode(12.76, 02.15, 614);
        
        Node n1115 = createNode(15.82, 0.50, 1115);   
        Node n1116 = createNode(16.71, 0.50, 1116);
        Node n1117 = createNode(15.82, 02.15, 1117);   
        Node n1118 = createNode(16.71, 02.15, 1118);

        Node n71 = createNode(17.885, 01.00, 71);
		Node n72 = createNode(18.535, 01.00, 72);
//        Node n63 = createNode(14.29, 01.50, 73);
        Node n74 = createNode(17.885, 01.825, 74);
        Node n75 = createNode(18.535, 01.825, 75);
        Node n76 = createNode(17.59, 02.15, 76);
        Node n77 = createNode(18.21, 02.80, 77);
        Node n78 = createNode(18.21, 03.30, 78);
        Node n79 = createNode(18.86, 02.15, 79);
        Node n710 = createNode(17.885, -9.00, 710);
        Node n711 = createNode(18.535, -9.00, 711);
        Node n712 = createNode(17.885, 0.50, 712);
        Node n713 = createNode(18.535, 0.50, 713);
//        Node n614 = createNode(12.76, 02.15, 714);

        Node n1215 = createNode(19.74, 0.50, 1215);   
        Node n1216 = createNode(20.63, 0.50, 1216);
        Node n1217 = createNode(19.74, 02.15, 1217);   
        Node n1218 = createNode(20.63, 02.15, 1218);
        
        Node n81 = createNode(21.805, 01.00, 81);
		Node n82 = createNode(22.455, 01.00, 82);
//        Node n63 = createNode(14.29, 01.50, 73);
        Node n84 = createNode(21.805, 01.825, 84);
        Node n85 = createNode(22.455, 01.825, 85);
        Node n86 = createNode(21.51, 02.15, 86);
        Node n87 = createNode(22.13, 02.80, 87);
        Node n88 = createNode(22.13, 03.30, 88);
        Node n89 = createNode(22.78, 02.15, 89);
        Node n810 = createNode(21.805, -9.00, 810);
        Node n811 = createNode(22.455, -9.00, 811);
        Node n812 = createNode(21.805, 0.50, 812);
        Node n813 = createNode(22.455, 0.50, 813);
//        Node n614 = createNode(12.76, 02.15, 714);

        Node n1315 = createNode(23.66, 0.50, 1315);   
        Node n1316 = createNode(24.55, 0.50, 1316);
        Node n1317 = createNode(23.66, 02.15, 1317);   
        Node n1318 = createNode(24.55, 02.15, 1318);
        
        Link l0 	= createLink	(n1, n12, 1, 0);
        Link l0_rev = createLink	(n12, n1, 2, 0);
        Link l1 	= createLink	(n12, n10, 1, 0);
        Link l1_rev = createLink	(n10, n12, 2, 0);
        Link l2 	= createLink	(n2, n13, 3, 0);
        Link l2_rev = createLink	(n13, n2, 4, 0);
        Link l3 	= createLink	(n11, n13, 3, 0);
        Link l3_rev = createLink	(n13, n11, 4, 0);
        Link l4 	= createLink	(n4, n1, 5, 1);
        Link l4_rev = createLink	(n1, n4, 6, 1);
        Link l5 	= createLink	(n2, n5, 7, 1);
        Link l5_rev = createLink	(n5, n2, 8, 1);
        Link l6 	= createLink	(n4, n5, 9, 1);
        Link l6_rev = createLink	(n5, n4, 10, 1);
        Link l7 	= createLink	(n6, n9, 11, 1);
        Link l7_rev = createLink	(n9, n6, 12, 1);
        Link l8 	= createLink	(n4, n6, 13, 1);
        Link l8_rev = createLink	(n6, n4, 14, 1);
        Link l9 	= createLink	(n9, n5, 15, 1);
        Link l9_rev = createLink	(n5 ,n9, 16, 1);
        Link l10 	= createLink	(n7, n6, 17, 1);
        Link l10_rev = createLink	(n6 ,n7, 18, 1);
        Link l11 	= createLink	(n7, n9, 19, 1);
        Link l11_rev = createLink	(n9 ,n7, 20, 1);
        Link l12 	= createLink	(n8, n7, 21, 1);
        Link l12_rev = createLink	(n7 ,n8, 22, 1);
        Link l13 	= createLink	(n14, n6, 23, 1);
        Link l13_rev = createLink	(n6 ,n14, 24, 1);
        Link l14 	= createLink	(n12, n13, 23, 1);
        Link l14_rev = createLink	(n13 ,n12, 24, 1);
        Link l15 	= createLink	(n12, n20, 23, 1);
        Link l15_rev = createLink	(n20 ,n12, 24, 1);
        Link l16 	= createLink	(n10, n11, 23, 1);
        Link l16_rev = createLink	(n11 ,n10, 24, 1);

        Link l91 	= createLink	(n17, n9, 49, 1);
        Link l91_rev= createLink	(n9 ,n17, 50, 1);
        Link l92 	= createLink	(n17, n18, 51, 1);
        Link l92_rev= createLink	(n18 ,n17, 52, 1);
        Link l93 	= createLink	(n15, n13, 49, 1);
        Link l93_rev= createLink	(n13 ,n15, 50, 1);
        Link l94 	= createLink	(n15, n16, 51, 1);
        Link l94_rev= createLink	(n16 ,n15, 52, 1);
        Link l95 	= createLink	(n412, n16, 51, 1);
        Link l95_rev= createLink	(n16 ,n412, 52, 1);

        Link l40 	= createLink	(n41, n412, 1, 0);
        Link l40_rev = createLink	(n412, n41, 2, 0);
        Link l41 	= createLink	(n412, n410, 1, 0);
        Link l41_rev = createLink	(n410, n412, 2, 0);
        Link l42 	= createLink	(n42, n413, 3, 0);
        Link l42_rev = createLink	(n413, n42, 4, 0);
        Link l43 	= createLink	(n411, n413, 3, 0);
        Link l43_rev = createLink	(n413, n411, 4, 0);
        Link l44 	= createLink	(n44, n41, 5, 1);
        Link l44_rev = createLink	(n41, n44, 6, 1);
        Link l45 	= createLink	(n42, n45, 7, 1);
        Link l45_rev = createLink	(n45, n42, 8, 1);
        Link l46 	= createLink	(n44, n45, 9, 1);
        Link l46_rev = createLink	(n45, n44, 10, 1);
        Link l47 	= createLink	(n46, n49, 11, 1);
        Link l47_rev = createLink	(n49, n46, 12, 1);
        Link l48 	= createLink	(n44, n46, 13, 1);
        Link l48_rev = createLink	(n46, n44, 14, 1);
        Link l49 	= createLink	(n49, n45, 15, 1);
        Link l49_rev = createLink	(n45 ,n49, 16, 1);
        Link l410 	= createLink	(n47, n46, 17, 1);
        Link l410_rev = createLink	(n46 ,n47, 18, 1);
        Link l411 	= createLink	(n47, n49, 19, 1);
        Link l411_rev = createLink	(n49 ,n47, 20, 1);
        Link l412 	= createLink	(n48, n47, 21, 1);
        Link l412_rev = createLink	(n47 ,n48, 22, 1);
        Link l413 	= createLink	(n18, n46, 23, 1);
        Link l413_rev = createLink	(n46 ,n18, 24, 1);
        Link l414 	= createLink	(n412, n413, 23, 1);
        Link l414_rev = createLink	(n413 ,n412, 24, 1);
        Link l416 	= createLink	(n410, n411, 23, 1);
        Link l416_rev = createLink	(n411 ,n410, 24, 1);
        
        Link l191 	= createLink	(n917, n49, 49, 1);
        Link l191_rev= createLink	(n49 ,n917, 50, 1);
        Link l192 	= createLink	(n917, n918, 51, 1);
        Link l192_rev= createLink	(n918 ,n917, 52, 1);
        Link l193 	= createLink	(n915, n413, 49, 1);
        Link l193_rev= createLink	(n413 ,n915, 50, 1);
        Link l194 	= createLink	(n915, n916, 51, 1);
        Link l194_rev= createLink	(n916 ,n915, 52, 1);
        Link l195 	= createLink	(n512, n916, 51, 1);
        Link l195_rev= createLink	(n916 ,n512, 52, 1);

        Link l50 	= createLink	(n51, n512, 1, 0);
        Link l50_rev = createLink	(n512, n51, 2, 0);
        Link l51 	= createLink	(n512, n510, 1, 0);
        Link l51_rev = createLink	(n510, n512, 2, 0);
        Link l52 	= createLink	(n52, n513, 3, 0);
        Link l52_rev = createLink	(n513, n52, 4, 0);
        Link l53 	= createLink	(n511, n513, 3, 0);
        Link l53_rev = createLink	(n513, n511, 4, 0);
        Link l54 	= createLink	(n54, n51, 5, 1);
        Link l54_rev = createLink	(n51, n54, 6, 1);
        Link l55 	= createLink	(n52, n55, 7, 1);
        Link l55_rev = createLink	(n55, n52, 8, 1);
        Link l56 	= createLink	(n54, n55, 9, 1);
        Link l56_rev = createLink	(n55, n54, 10, 1);
        Link l57 	= createLink	(n56, n59, 11, 1);
        Link l57_rev = createLink	(n59, n56, 12, 1);
        Link l58 	= createLink	(n54, n56, 13, 1);
        Link l58_rev = createLink	(n56, n54, 14, 1);
        Link l59 	= createLink	(n59, n55, 15, 1);
        Link l59_rev = createLink	(n55 ,n59, 16, 1);
        Link l510 	= createLink	(n57, n56, 17, 1);
        Link l510_rev = createLink	(n56 ,n57, 18, 1);
        Link l511 	= createLink	(n57, n59, 19, 1);
        Link l511_rev = createLink	(n59 ,n57, 20, 1);
        Link l512 	= createLink	(n58, n57, 21, 1);
        Link l512_rev = createLink	(n57 ,n58, 22, 1);
        Link l513 	= createLink	(n918, n56, 23, 1);
        Link l513_rev = createLink	(n56 ,n918, 24, 1);
        Link l514 	= createLink	(n512, n513, 23, 1);
        Link l514_rev = createLink	(n513 ,n512, 24, 1);
        Link l516 	= createLink	(n510, n511, 23, 1);
        Link l516_rev = createLink	(n511 ,n510, 24, 1);
        
        Link l291 	= createLink	(n1017, n59, 49, 1);
        Link l291_rev= createLink	(n59 ,n1017, 50, 1);
        Link l292 	= createLink	(n1017, n1018, 51, 1);
        Link l292_rev= createLink	(n1018 ,n1017, 52, 1);
        Link l293 	= createLink	(n1015, n513, 49, 1);
        Link l293_rev= createLink	(n513 ,n1015, 50, 1);
        Link l294 	= createLink	(n1015, n1016, 51, 1);
        Link l294_rev= createLink	(n1016 ,n1015, 52, 1);
        Link l295 	= createLink	(n612, n1016, 51, 1);
        Link l295_rev= createLink	(n1016 ,n612, 52, 1);

        Link l60 	= createLink	(n61, n612, 1, 0);
        Link l60_rev = createLink	(n612, n61, 2, 0);
        Link l61 	= createLink	(n612,n610, 1, 0);
        Link l61_rev = createLink	(n610,n612, 2, 0);
        Link l62 	= createLink	(n62, n613, 3, 0);
        Link l62_rev = createLink	(n613,n62, 4, 0);
        Link l63 	= createLink	(n611,n613, 3, 0);
        Link l63_rev = createLink	(n613,n611, 4, 0);
        Link l64 	= createLink	(n64, n61, 5, 1);
        Link l64_rev = createLink	(n61, n64, 6, 1);
        Link l65 	= createLink	(n62, n65, 7, 1);
        Link l65_rev = createLink	(n65, n62, 8, 1);
        Link l66 	= createLink	(n64, n65, 9, 1);
        Link l66_rev = createLink	(n65, n64, 10, 1);
        Link l67 	= createLink	(n66, n69, 11, 1);
        Link l67_rev = createLink	(n69, n66, 12, 1);
        Link l68 	= createLink	(n64, n66, 13, 1);
        Link l68_rev = createLink	(n66, n64, 14, 1);
        Link l69 	= createLink	(n69, n65, 15, 1);
        Link l69_rev = createLink	(n65 ,n69, 16, 1);
        Link l610 	= createLink	(n67, n66, 17, 1);
        Link l610_rev = createLink	(n66 ,n67, 18, 1);
        Link l611 	= createLink	(n67, n69, 19, 1);
        Link l611_rev = createLink	(n69 ,n67, 20, 1);
        Link l612 	= createLink	(n68, n67, 21, 1);
        Link l612_rev = createLink	(n67 ,n68, 22, 1);
        Link l613 	= createLink	(n1018, n66, 23, 1);
        Link l613_rev = createLink	(n66 ,n1018, 24, 1);
        Link l614 	= createLink	(n612, n613, 23, 1);
        Link l614_rev = createLink	(n613 ,n612, 24, 1);
        Link l616 	= createLink	(n610, n611, 23, 1);
        Link l616_rev = createLink	(n611 ,n610, 24, 1);
        
        Link l391 	= createLink	(n1117, n69, 49, 1);
        Link l391_rev= createLink	(n69 ,	n1117, 50, 1);
        Link l392 	= createLink	(n1117, n1118, 51, 1);
        Link l392_rev= createLink	(n1118 ,n1117, 52, 1);
        Link l393 	= createLink	(n1115, n613, 49, 1);
        Link l393_rev= createLink	(n613 ,	n1115, 50, 1);
        Link l394 	= createLink	(n1115, n1116, 51, 1);
        Link l394_rev= createLink	(n1116 ,n1115, 52, 1);
        Link l395 	= createLink	(n712, n1116, 51, 1);
        Link l395_rev= createLink	(n1116 ,n712, 52, 1);

        Link l70 	= createLink	(n71, n712, 1, 0);
        Link l70_rev = createLink	(n712, n71, 2, 0);
        Link l71 	= createLink	(n712,n710, 1, 0);
        Link l71_rev = createLink	(n710,n712, 2, 0);
        Link l72 	= createLink	(n72, n713, 3, 0);
        Link l72_rev = createLink	(n713,n72, 4, 0);
        Link l73 	= createLink	(n711,n713, 3, 0);
        Link l73_rev = createLink	(n713,n711, 4, 0);
        Link l74 	= createLink	(n74, n71, 5, 1);
        Link l74_rev = createLink	(n71, n74, 6, 1);
        Link l75 	= createLink	(n72, n75, 7, 1);
        Link l75_rev = createLink	(n75, n72, 8, 1);
        Link l76 	= createLink	(n74, n75, 9, 1);
        Link l76_rev = createLink	(n75, n74, 10, 1);
        Link l77 	= createLink	(n76, n79, 11, 1);
        Link l77_rev = createLink	(n79, n76, 12, 1);
        Link l78 	= createLink	(n74, n76, 13, 1);
        Link l78_rev = createLink	(n76, n74, 14, 1);
        Link l79 	= createLink	(n79, n75, 15, 1);
        Link l79_rev = createLink	(n75 ,n79, 16, 1);
        Link l710 	= createLink	(n77, n76, 17, 1);
        Link l710_rev = createLink	(n76 ,n77, 18, 1);
        Link l711 	= createLink	(n77, n79, 19, 1);
        Link l711_rev = createLink	(n79 ,n77, 20, 1);
        Link l712 	= createLink	(n78, n77, 21, 1);
        Link l712_rev = createLink	(n77 ,n78, 22, 1);
        Link l713 	= createLink	(n1118, n76, 23, 1);
        Link l713_rev = createLink	(n76 ,n1118, 24, 1);
        Link l714 	= createLink	(n712, n713, 23, 1);
        Link l714_rev = createLink	(n713 ,n712, 24, 1);
        Link l716 	= createLink	(n710, n711, 23, 1);
        Link l716_rev = createLink	(n711 ,n710, 24, 1);
        
        Link l491 	= createLink	(n1217, n79, 49, 1);
        Link l491_rev= createLink	(n79 ,	n1217, 50, 1);
        Link l492 	= createLink	(n1217, n1218, 51, 1);
        Link l492_rev= createLink	(n1218 ,n1217, 52, 1);
        Link l493 	= createLink	(n1215, n713, 49, 1);
        Link l493_rev= createLink	(n713 ,	n1215, 50, 1);
        Link l494 	= createLink	(n1215, n1216, 51, 1);
        Link l494_rev= createLink	(n1216 ,n1215, 52, 1);
        Link l495 	= createLink	(n812, n1216, 51, 1);
        Link l495_rev= createLink	(n1216 ,n812, 52, 1);

        Link l80 	= createLink	(n81, n812, 1, 0);
        Link l80_rev = createLink	(n812, n81, 2, 0);
        Link l81 	= createLink	(n812,n810, 1, 0);
        Link l81_rev = createLink	(n810,n812, 2, 0);
        Link l82 	= createLink	(n82, n813, 3, 0);
        Link l82_rev = createLink	(n813,n82, 4, 0);
        Link l83 	= createLink	(n811,n813, 3, 0);
        Link l83_rev = createLink	(n813,n811, 4, 0);
        Link l84 	= createLink	(n84, n81, 5, 1);
        Link l84_rev = createLink	(n81, n84, 6, 1);
        Link l85 	= createLink	(n82, n85, 7, 1);
        Link l85_rev = createLink	(n85, n82, 8, 1);
        Link l86 	= createLink	(n84, n85, 9, 1);
        Link l86_rev = createLink	(n85, n84, 10, 1);
        Link l87 	= createLink	(n86, n89, 11, 1);
        Link l87_rev = createLink	(n89, n86, 12, 1);
        Link l88 	= createLink	(n84, n86, 13, 1);
        Link l88_rev = createLink	(n86, n84, 14, 1);
        Link l89 	= createLink	(n89, n85, 15, 1);
        Link l89_rev = createLink	(n85 ,n89, 16, 1);
        Link l810 	= createLink	(n87, n86, 17, 1);
        Link l810_rev = createLink	(n86 ,n87, 18, 1);
        Link l811 	= createLink	(n87, n89, 19, 1);
        Link l811_rev = createLink	(n89 ,n87, 20, 1);
        Link l812 	= createLink	(n88, n87, 21, 1);
        Link l812_rev = createLink	(n87 ,n88, 22, 1);
        Link l813 	= createLink	(n1218, n86, 23, 1);
        Link l813_rev = createLink	(n86 ,n1218, 24, 1);
        Link l814 	= createLink	(n812, n813, 23, 1);
        Link l814_rev = createLink	(n813 ,n812, 24, 1);
        Link l816 	= createLink	(n810, n811, 23, 1);
        Link l816_rev = createLink	(n811 ,n810, 24, 1);
        
        Link l591 	= createLink	(n1317, n89, 49, 1);
        Link l591_rev= createLink	(n89 ,	n1317, 50, 1);
        Link l592 	= createLink	(n1317, n1318, 51, 1);
        Link l592_rev= createLink	(n1318 ,n1317, 52, 1);
        Link l593 	= createLink	(n1315, n813, 49, 1);
        Link l593_rev= createLink	(n813 ,	n1315, 50, 1);
        Link l594 	= createLink	(n1315, n1316, 51, 1);
        Link l594_rev= createLink	(n1316 ,n1315, 52, 1);
//        Link l295 	= createLink(n512, n1016, 51, 1);
//        Link l295_rev= createLink(n1016 ,n512, 52, 1);
	}
	
   	public Map<Integer, Link> getLinks() {
		return links;
	}
   	
   	public Map<Integer, Node> getNodes() {
		return nodes;
	}

   	public Node createNode(double x, double y, int id) {
   		Node n = new Node(x,y,id);
   		this.nodes.put(id,n);
   		return n;
   	}

   	public Link createLink(Node from, Node to, int id, int room) {
   		Link l = new Link(from,to,id,room);
   		this.links.put(id,l);
   		from.addOutLink(l);
   		to.addInLink(l);
        LinkInfo li = new LinkInfo();
        li.x0 = (float)(from.getX()*Simulation.SCALE);
        li.y0 = (float)(from.getY()*Simulation.SCALE);
        li.x1 = (float)(to.getX()*Simulation.SCALE);
        li.y1 = (float)(to.getY()*Simulation.SCALE);
        linkInfos.add(li);
   		return l;
   	}

	public void draw(PApplet p) {
//		p.stroke(0,255);
//		p.strokeWeight(1);
//   	    for (LinkInfo linkInfo : this.linkInfos) {
//   	        p.line(linkInfo.x0,linkInfo.y0,linkInfo.x1,linkInfo.y1);
//        }

	}

	private static final class LinkInfo {
   	    float x0;
   	    float y0;
   	    float x1;
   	    float y1;
    }
	
}
