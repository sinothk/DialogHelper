# dialog
对话框

# step 1
    dependencies {
        implementation 'com.github.sinothk:DialogHelper:3.0.0707'
    }
    
# step 2
        DialogHelper.getLoading(LoadingDemoMainActivity.this).show("正在登录");//有文字提示
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogHelper.getLoading(LoadingDemoMainActivity.this).dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
