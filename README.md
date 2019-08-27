# dialog
对话框

# step 1
    dependencies {
        implementation 'com.github.sinothk:DialogHelper:3.19.00829'
    }
    
# step 2
       DialogView.init(this);
        
       DialogView.loading().show(false);//无文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogView.loading().dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);

     DialogView.loading().show(false, "正在登录");//有文字提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogView.loading().dismiss(); //隐藏对话框
                    }
                });
            }
        }, 5000);
