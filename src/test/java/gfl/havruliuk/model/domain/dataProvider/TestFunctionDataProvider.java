package gfl.havruliuk.model.domain.dataProvider;

import org.testng.annotations.DataProvider;


public class TestFunctionDataProvider {


    @DataProvider(name = "testDataSolveFunction")
    private static Object[][] dataForSolveFunction() {
        return new Object[][] {
                { -1000000, 2700000300004.0 },
                { -100, 27034 },
                { -5, 73 },
                { 0, 4 },
                { 5, 0.235339362 },
                { 100, -0.272986351 },
                { 1000000, -0.2999973 },

                { -8.0e150, 1.728e+302 },
                { -1000000.5555559, 2700003300006.8600011 },
                { 0.01, 3.99727 },
                { 1.4, 3.649036482 },
                { 1000000.5555559, -0.2999973 },
                { 8.0e150, -0.299172257 },
        };
    }

//
//    @DataProvider(name = "testDataArraySize")
//    private static Object[][] dataArraySize() {
//        return new Object[][] {
////          start, end, interval, steps
//                { 0, 1, 1, 2 },
//                { 0, 2, 1, 3 },
//                { 1, 10, 1, 10 },
//                { 0, 1000, 1, 1001 },
//
//                { 0, 10, 2, 6 },
//                { 0, 11, 2, 6 },
//
//                { -10, 0, 2, 6 },
//                { -11, 0, 2, 6 },
//
//                { -10, 10, 2, 11 },
//                { -10, 11, 2, 11 },
//                { -11, 11, 2, 12 },
//
//                { 0, 0, 0.1, 1 },
//                { 0, 5, 10, 1 },
//
//                { 0, 1.1, 0.1, 12 },
//                { 0, 1.1, 0.2, 6 },
//                { 0, 1.1, 0.3, 4 },
//                { 0, 1.1, 0.4, 3 },
//                { 0, 1.1, 0.5, 3 },
//                { 0, 1.1, 0.6, 2 },
//
//                { -1, 0, 0.2, 6 },
//                { -1, 1, 0.2, 11 },
//
//                { 0, 2, 0.002, 1001 },
//
//        };
//    }
//
//
//
//    @DataProvider(name = "testDataArraySizeNegative")
//    private static Object[][] dataArraySizeNegative() {
//        return new Object[][] {
////          start, end, interval, steps
//                { 0, 1, 1, 1 },
//                { 0, 2, 1, 2 },
//                { 1, 10, 1, 11 },
//                { 0, 1000, 1, 1000 },
//
//                { 0, 10, 2, 5 },
//                { 0, 10, 2, 7 },
//                { 0, 11, 2, 5 },
//                { 0, 11, 2, 7 },
//
//                { 0, 0, 0.1, 0 },
//                { 0, 0, 0.1, 2 },
//
//                { -1, 0, 0.2, 7 },
//                { -1, 0, 0.2, 8 },
//
//                { 0, 2, 0.002, 1000 },
//
//        };
//    }
//
//    @DataProvider(name = "testDataArraySizeStartLargerEndException")
//    private static Object[][] dataArraySizeStartLargerEndException() {
//        return new Object[][] {
////          start, end, interval,
//                { 1, 0, 1},
//                { 1, -1, 1},
//                { 0, -1, 1},
//                { 1, -1, 1},
//        };
//    }
//
//    @DataProvider(name = "testDataArraySizeIntervalNegativeOrZeroException")
//    private static Object[][] dataArraySizeIntervalNegativeOrZeroException() {
//        return new Object[][] {
////          start, end, interval,
//                { 0, 1, 0},
//                { 1, 2, -1},
//                { 1, 5, -10},
//
//        };
//    }
//
//
//
//    @DataProvider(name = "testDataGetArgumentsArray")
//    private static Object[][] dataGetArgumentsArray() {
//        return new Object[][] {
////               start, end, interval, array
//                { 0, 1, 1, new double[]{0, 1} },
//                { 0, 2, 1, new double[]{0, 1, 2} },
//                { 1, 10, 1, new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}  },
//
//                { 0, 10, 2, new double[]{0, 2, 4, 6, 8, 10} },
//                { 0, 11, 2, new double[]{0, 2, 4, 6, 8, 10} },
//
//                { 0, 0, 0.1, new double[]{0} },
//                { 0, 5, 10, new double[]{0} },
//
//                { 0, 1.1, 0.1, new double[]{0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1} },
//                { 0, 1.1, 0.2, new double[]{0, 0.2, 0.4, 0.6, 0.8, 1.0} },
//                { 0, 1.1, 0.3, new double[]{0, 0.3, 0.6, 0.9} },
//                { 0, 1.1, 0.4, new double[]{0, 0.4, 0.8} },
//                { 0, 1.1, 0.5, new double[]{0, 0.5, 1.0} },
//                { 0, 1.1, 0.6, new double[]{0, 0.6} },
//
//                { -1.1, 0, 0.1, new double[]{-1.1, -1.0, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0} },
//                { -1.1, 0, 0.2, new double[]{-1.1, -0.9, -0.7, -0.5, -0.3, -0.1} },
//                { -1.1, 0, 0.3, new double[]{-1.1, -0.8, -0.5, -0.2} },
//                { -1.1, 0, 0.4, new double[]{-1.1, -0.7, -0.3} },
//                { -1.1, 0, 0.5, new double[]{-1.1, -0.6, -0.1} },
//                { -1.1, 0, 0.6, new double[]{-1.1, -0.5} },
//        };
//    }
//
//
//    @DataProvider(name = "testDataGetFunctionValuesArray")
//    private static Object[][] dataGetFunctionValuesArray() {
//        return new Object[][] {
//
////               arguments, functionValues
//                { new double[]{}, new double[]{} },
//                { new double[]{0, 1.4, 1.998}, new double[]{4, 3.649037, 0.940169} },
//                { new double[]{0}, new double[]{4} },
//                { new double[]{0, 1}, new double[]{4, 6.4} },
//                { new double[]{0, 1, 1.4, 2}, new double[]{4, 6.4, 3.649037, 0.939148} },
//
//                { new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                        new double[]{6.4, 0.939148, 0.569210, 0.363803, 0.235339, 0.147959, 0.084853, 0.037210, 0, -0.029851} },
//
//                { new double[]{0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1},
//                        new double[]{4, 3.997, 4.048, 4.153, 4.312, 4.525, 4.792, 5.113, 5.488, 5.917, 6.4, 6.937} },
//
//                { new double[]{-1.1, -1.0, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0},
//                        new double[]{7.597, 7, 6.457, 5.968, 5.533, 5.152, 4.825, 4.552, 4.333, 4.168, 4.057, 4} },
//        };
//    }
//
//
//
//    @DataProvider(name = "testDataGetMaxValueIndex")
//    private static Object[][] dataGetMaxValueIndex() {
//        return new Object[][] {
////               array, maxValueIndex
//                { new double[]{4, 3.649037, 0.940169}, 0 },
//                { new double[]{4}, 0},
//                { new double[]{0}, 0 },
//                { new double[]{4, 6.4}, 1},
//                { new double[]{6.4, 4, 6.4}, 0},
//                { new double[]{4, 6.4, 3.649037, 0.939148}, 1 },
//                { new double[]{6.4, 0.939148, 0.569210, 0.363803, 0.147959, 0.084853, 0.037210, 0, -0.029851}, 0 },
//                { new double[]{0.569210, 0.939148, 6.4, 0.235339, -0.029851, 0.147959, 0.084853, 0, 0.037210}, 2 },
//                { new double[]{-3.997, -4.153, -4, -4.312, -6.937,  -5.113,  -5.917, -6.4}, 0 },
//                { new double[]{-3.997, -4.153, -4, 0, -4.312, -6.937,  -5.113,  -5.917, -6.4}, 3 },
//                { new double[]{7, 6.457, 5.533, 7.597, 4.825, 4.552, 4.333, 4.168, 4.057, 5.968, 4, 5.152}, 3 },
//        };
//    }
//
//    @DataProvider(name = "testDataGetMinValueIndex")
//    private static Object[][] dataGetMinValueIndex() {
//        return new Object[][] {
////               array, minValue
//                { new double[]{4, 3.649037, 0.940169}, 2 },
//                { new double[]{4}, 0},
//                { new double[]{0}, 0 },
//                { new double[]{4, 6.4}, 0},
//                { new double[]{4, 6.4, 4,}, 0},
//                { new double[]{4, 6.4, 3.649037, 0.939148}, 3 },
//                { new double[]{6.4, 0.939148, 0.569210, 0.363803, 0.147959, 0.084853, 0.037210, 0, -0.029851}, 8 },
//                { new double[]{0.569210, 0.939148, 6.4, 0.235339, -0.029851, 0.147959, 0.084853, 0, 0.037210}, 4 },
//                { new double[]{-3.997, -4.153, -4, -4.312, -6.937,  -5.113,  -5.917, -6.4}, 4 },
//                { new double[]{-3.997, -4.153, -4, 0, -4.312, -6.937,  -5.113,  -5.917, -6.4}, 5 },
//                { new double[]{7, 6.457, 5.533, 7.597, 4.825, 4.552, 4.333, 4.168, 4.057, 5.968, 4, 5.152}, 10 },
//        };
//    }
//
//
//    @DataProvider(name = "testDataGetSumOfValues")
//    private static Object[][] dataGetSumOfValues() {
//        return new Object[][] {
////               array, sum
//                { new double[]{4, 3.649037, 0.940169}, 8.589206 },
//                { new double[]{4}, 4},
//                { new double[]{0}, 0 },
//                { new double[]{4, 6.4}, 10.4},
//                { new double[]{4, 6.4, 3.649037, 0.939148}, 14.988185 },
//                { new double[]{6.4, 0.939148, 0.569210, 0.363803, 0.147959, 0.084853, 0.037210, 0, -0.029851}, 8.512332 },
//                { new double[]{-3.997, -4.153, -4, -4.312, -6.937,  -5.113,  -5.917, -6.4}, -40.829 },
//                { new double[]{7, 6.457, 5.533, 7.597, 4.825, 4.552, 4.333, 4.168, 4.057, 5.968, 4, 5.152}, 63.642 },
//        };
//    }
//
//    @DataProvider(name = "testDataGetAvgValue")
//    private static Object[][] dataGetAvgValue() {
//        return new Object[][] {
////               array, avg
//                { new double[]{4, 3.649037, 0.940169}, 2.863069 },
//                { new double[]{4}, 4},
//                { new double[]{0}, 0 },
//                { new double[]{4, 6.4}, 5.2},
//                { new double[]{4, 6.4, 3.649037, 0.939148}, 3.7470466 },
//                { new double[]{6.4, 0.939148, 0.569210, 0.363803, 0.147959, 0.084853, 0.037210, 0, -0.029851}, 0.945815 },
//                { new double[]{-3.997, -4.153, -4, -4.312, -6.937,  -5.113,  -5.917, -6.4}, -5.103625 },
//                { new double[]{7, 6.457, 5.533, 7.597, 4.825, 4.552, 4.333, 4.168, 4.057, 5.968, 4, 5.152}, 5.3035 },
//        };
//    }
//
//
//
//    @DataProvider(name = "testDataPrintMaxValueByIndex")
//    private static Object[][] dataPrintMaxValueByIndex() {
//        return new Object[][] {
//
////               arguments, maxValue
//                { new double[]{4, 3.649037, 0.940169}, 4 },
//                { new double[]{0}, 0 },
//                { new double[]{6.4, 4, 6.4}, 6.4},
//                { new double[]{0.569210, 0.939148, 6.4, 0.235339, -0.029851, 0.147959, 0.084853, 0, 0.037210}, 6.4 },
//                { new double[]{-3.997, -4.153, -4, 0, -4.312, -6.937,  -5.113,  -5.917, -6.4}, 0 },
//        };
//    }
//
//    @DataProvider(name = "testDataPrintMaxValueByIndexFailed")
//    private static Object[][] dataPrintMaxValueByIndexFailed() {
//        return new Object[][] {
//
////               arguments, maxValue
//                { new double[]{4, 3.649037, 0.940169}, 3.649037 },
//                { new double[]{6.4, 4, 6.4}, 4},
//                { new double[]{0.569210, 0.939148, 6.4, 0.235339, -0.029851, 0.147959, 0.084853, 0, 0.037210}, 0.939148 },
//        };
//    }
//
//
//
//    @DataProvider(name = "testDataPrintMinValueByIndex")
//    private static Object[][] dataPrintMinValueByIndex() {
//        return new Object[][] {
//
////               arguments, minValue
//                { new double[]{4, 3.649037, 0.940169}, 0.940169 },
//                { new double[]{0}, 0 },
//                { new double[]{4, 6.4, 4}, 4},
//                { new double[]{0.569210, 0.939148, 6.4, 0.235339, -0.029851, 0.147959, 0.084853, 0, 0.037210}, -0.029851 },
//                { new double[]{-3.997, -4.153, -4, 0, -4.312, -6.937,  -5.113,  -5.917, -6.4}, -6.937 },
//        };
//    }
//
//    @DataProvider(name = "testDataPrintMinValueByIndexFailed")
//    private static Object[][] dataPrintMinValueByIndexFailed() {
//        return new Object[][] {
//
////               arguments, minValue
//                { new double[]{4, 3.649037, 0.940169}, 3.649037 },
//                { new double[]{4, 6.4, 4}, 6.4},
//                { new double[]{0.569210, 0.939148, 6.4, 0.235339, -0.029851, 0.147959, 0.084853, 0, 0.037210}, 0 },
//        };
//    }

}