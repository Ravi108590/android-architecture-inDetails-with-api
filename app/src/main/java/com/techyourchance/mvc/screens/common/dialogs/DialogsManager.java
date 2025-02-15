package com.techyourchance.mvc.screens.common.dialogs;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.dialogs.infodialog.InfoDialog;
import com.techyourchance.mvc.screens.common.dialogs.promptdialog.PromptDialog;
import com.techyourchance.mvc.screens.common.dialogs.userdialog.UserDialog;

public class DialogsManager {

    private final Context mContext;
    private final FragmentManager mFragmentManager;

    public DialogsManager(Context context, FragmentManager fragmentManager) {
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    // Shows the network related error
    public void showUseCaseErrorDialog(@Nullable String tag) {
        DialogFragment dialogFragment = PromptDialog.newPromptDialog(
                getString(R.string.error_network_call_failed_title),
                getString(R.string.error_network_call_failed_message),
                getString(R.string.error_network_call_failed_positive_button_caption),
                getString(R.string.error_network_call_failed_negative_button_caption)
        );
        dialogFragment.show(mFragmentManager, tag);
    }

    // here all the permissions string used as an arguments to show into the dialog
    // permissions related msg
    public void showPermissionGrantedDialog(@Nullable String tag) {
        DialogFragment dialogFragment = InfoDialog.newInfoDialog(
                getString(R.string.permission_dialog_title),
                getString(R.string.permission_dialog_granted_message),
                getString(R.string.permission_dialog_button_caption)
        );
        dialogFragment.show(mFragmentManager, tag);
    }

    public void showPermissionDeclinedCantAskMoreDialog(@Nullable String tag) {
        DialogFragment dialogFragment = InfoDialog.newInfoDialog(
                getString(R.string.permission_dialog_title),
                getString(R.string.permission_dialog_cant_ask_more),
                getString(R.string.permission_dialog_button_caption)
        );
        dialogFragment.show(mFragmentManager, tag);
    }

    // userDialog
    public void userInfoDialog(@Nullable String tag, String name, String url) {
        DialogFragment dialogFragment = UserDialog.newUserDialog(
                name , url,"ok"
        );
        dialogFragment.show(mFragmentManager,tag);
    }
    public void showDeclinedDialog(@Nullable String tag) {
        DialogFragment dialogFragment = InfoDialog.newInfoDialog(
                getString(R.string.permission_dialog_title),
                getString(R.string.permission_dialog_user_declined),
                getString(R.string.permission_dialog_button_caption)
        );
        dialogFragment.show(mFragmentManager, tag);
    }

    private String getString(int stringId) {
        return mContext.getString(stringId);
    }

    public @Nullable String getShownDialogTag() {
        for (Fragment fragment : mFragmentManager.getFragments()) {
            if (fragment instanceof BaseDialog) {
                return fragment.getTag();
            }
        }
        return null;
    }

}
