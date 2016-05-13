package cat.dcat.lprootbroker;

import android.content.Intent;
import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by DCat on 2016/5/13.
 */
public class LPRootHook implements IXposedHookLoadPackage {
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XC_MethodHook thisHook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param)
                    throws Throwable {
            }

            @Override
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam param)
                    throws Throwable {
                param.setResult(true);
            }
        };

        if (lpparam.packageName.equals("jp.co.happyelements.mirror")) {
            XposedHelpers.findAndHookMethod("jp.co.happyelements.cheatchecker.CheatChecker", lpparam.classLoader, "validate", thisHook);
            XposedBridge.log("LPRootCheck Hooked");
        }
    }

}
