package excel;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;


public class ExcelToolsService {

    public void execMacro(String excelPath, String macroName, Variant... params) throws Exception {


        ActiveXComponent excel = null;
        Dispatch workbooks = null;
        Dispatch workbook = null;
        long start = System.currentTimeMillis();
        System.out.println(start);

        try {
            ComThread.InitSTA();

            excel = new ActiveXComponent("Excel.Application");
            workbooks = excel.getProperty("Workbooks").toDispatch();
            workbook = Dispatch.call(workbooks, "Open", excelPath).toDispatch();
            if (null == params || params.length < 1) {
                Dispatch.call(excel, "Run", new Variant(macroName));
            } else {
                Dispatch.call(excel, "Run", new Variant(macroName), params);
            }
            Dispatch.call(workbook, "Save");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != workbook) {// 关闭文档
                Dispatch.call(workbook, "Close", new Variant(false));
            }
            if (null != workbooks) {
                Dispatch.call(workbooks, "Close");
            }
            if (null != excel) {
                excel.invoke("Quit", new Variant[] {});
            }

            // 关闭Excel进程
            ComThread.Release();

            long end = System.currentTimeMillis();
            System.out.println("处理文件[{}]宏[{}],共耗时{}s" + excelPath + macroName
                + ((end - start) / 1000 + 1));
        }
    }

}
