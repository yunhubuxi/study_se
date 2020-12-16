package dp;

import java.util.Scanner;

public class EggDropPuzzle {
    public static void main(String[] args) {
        int floors = 100;
        int eggs = 4;
        // System.out.println(computeMinDropsInWorstCase(eggs, floors));
        System.out.println(dropEggs(eggs,floors));
        // Scanner sin =new Scanner(System.in);
        // while(sin.hasNext()) {
        //     String[]temp=sin.nextLine().split("\\s+");
        //     int eggs=Integer.parseInt(temp[0]);
        //     int floors=Integer.parseInt(temp[1]);
            // System.out.println(dropEggs(eggs,floors));
            // System.out.println(dropEggs2(eggs,floors));
        // }
    }


    private static int computeMinDropsInWorstCase(int eggs, int floors) {
        int table[][] = new int[eggs + 1][floors + 1];
        // boundary condition:
        // if no floors or 1 floors, only need 0 trails or 1 trails

        for (int i = 0; i <= eggs; i++) {
            table[i][1] = 1;
            table[i][0] = 0;
        }


        // if only one egg,   f(1,k) = k

        for (int j = 0; j <= floors; j++) {
            table[1][j] = j;
        }

        // for the rest of cases
        // f( eggs, floors) = 1+ Max(f( eggs-1 , floors-1), f( eggs, floors-x))
        // x is the floor number we choose to drop for current attempt
        // range of i = 1,2,.....,floors,
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {

                table[i][j] = Integer.MAX_VALUE;  // so important

                for (int floorTriedFirst = 1; floorTriedFirst <= j; floorTriedFirst++) {
                    int res = 1 + Integer.max(table[i - 1][floorTriedFirst - 1],
                        table[i][j - floorTriedFirst]);
                    if (res < table[i][j]) {
                        table[i][j] = res;
                    }
                }

            }
        }

        for (int i = 0; i < table.length; i++) {
            for (int i1 = 0; i1 < table[i].length; i1++) {
                System.out.print(table[i][i1] + " ");
            }
            System.out.println();
        }

        return table[eggs][floors];
    }

    //(1)动态规划法:  该算法的空间复杂度是O(nk)，时间复杂度是O(nk^2) n表示鸡蛋数，k代表楼层数
    public static int dropEggs(int eggs, int floors) {
        //第一步永远是创建动态规划的备忘录,也叫状态转移矩阵
        //记住：二维数组里的length是0-start的，又因为包含层数为0或鸡蛋为0的情况，所以定义行高和列宽的时候自然要加1
        int[][] dp = new int[eggs + 1][floors + 1];

        //第二步永远是考虑边界，也就是初始化动态规划的备忘录
        //先考虑eggs的边界
        for (int i = 0; i != floors + 1; i++) {
            //首先是eggs=0的情况
            dp[0][i] = 0;
            //然后是eggs=1的情况
            //eggs=1的时候，肯定是从第0层一直往上实验
            dp[1][i] = i;
        }
        //再考虑floors的边界
        for (int i = 1; i != eggs + 1; i++) {
            //首先是floors=0的情况
            dp[i][0] = 0;
            //然后是floors=1的情况
            dp[i][1] = 1;
        }
        //第三步就是状态方程了
        //找递推过程中的两个紧邻步骤之间的关系，如何由子结果得到母结果
        //首先，鸡蛋要从2个开始算，因为0个和1个情况你已经考虑完了
        for (int egg = 2; egg != eggs + 1; egg++) {
            //楼层有多高要从2层起步，因为0层和1层的情况你也考虑完了
            for (int floor = 2; floor != floors + 1; floor++) {
                //看这里！这里就是你还有egg个鸡蛋，一共有floor层的子问题！
                //这里定义一个变量来存储最终结果，找到在哪层扔能达到所扔次数最少的目标
                int result = Integer.MAX_VALUE;
                for (int drop = 1; drop != floor + 1; drop++) {
                    //这里！就是在当前子问题中，你从第drop层扔鸡蛋的情况！
                    //第一种情况，哎呀~碎了！那么剩下的问题就转化成了如何在drop-1层，用egg-1个鸡蛋寻找最优
                    int broken = dp[egg - 1][drop - 1];
                    //第二种请看，卧槽~没碎！问题就转化成了如果再floos-drop层，用egg个鸡蛋寻找最优解
                    int unbroken = dp[egg][floor - drop];
                    //两种情况我肯定要取最大值，因为我根本不确定鸡蛋会不会碎，我特么又不是先知
                    int condition = Math.max(broken, unbroken) + 1;
                    //不断的和上一次的结果做比较，只为得到最优的结果，最少的扔鸡蛋次数！
                    result = Math.min(condition, result);
                }
                //当前子问题（当我有egg个鸡蛋，一共有floor层时）已经for循环完了！撒花~~接下来，就是把结果存到我们的结果矩阵里了！
                dp[egg][floor] = result;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[i].length; i1++) {
                int a = dp[i][i1];
                String b = "";
                if (dp[i][i1] < 10) {
                    b = "00" + a ;
                } else if (a < 100) {
                    b = "0" + a;
                } else {
                    b = a + "";
                }
                System.out.print(b + " ");
            }
            System.out.println();
        }
        //以上的步骤在不断的往状态矩阵（我把它称作装满结果的大盘子！）填充结果！到这里已经都填充完毕，我们自然就可以取到我们想要的结果啦
        return dp[eggs][floors];
    }

    //(2)公式法   递推公式法
    public static int dropEggs2(int eggs, int floors) {

        int times = 1;

        while (DroppingMax(eggs, times) < floors) {
            ++times;
        }

        return times;
    }

    public static int DroppingMax(int eggs, int times) {
        if (eggs == 1) {
            return times;
        }

        if (eggs >= times) {
            return (int) Math.pow(2, times) - 1;
        }

        return DroppingMax(eggs, times - 1) + DroppingMax(eggs - 1, times - 1) + 1;
    }


}
