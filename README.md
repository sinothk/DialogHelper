# dialog
对话框

# step 1
    dependencies {
        implementation 'com.github.sinothk:DialogHelper:5.x.1029'
    }
    
# step 2
    loadingDialog -> {
        QDialogView.loading(this).show(false)
    }

    okOrCancelDialog -> {
        QDialogView.center(this).show("标题", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容", "提交", false) {
            Toast.makeText(this, "提交操作 ...", Toast.LENGTH_SHORT).show()
        }
    }
