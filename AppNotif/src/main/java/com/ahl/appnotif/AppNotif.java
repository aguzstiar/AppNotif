package com.ahl.appnotif;

import android.content.Context;

import com.varunjohn1990.iosdialogs4android.IOSDialog;

public class AppNotif {

   public interface Listener {
      void onClick(AppNotif appNotif);
   }

   private final IOSDialog.Builder builder;
   Context context;
   private Listener positiveClickListener;
   private Listener negativeClickListener;
   private Listener cancelListener;


   private AppNotif(Context context) {
      this.context = context;
      builder = new IOSDialog.Builder(context);
   }

   public void show() {
      builder.build().show();
   }

   public void dismiss() {
      builder.build().dismiss();
   }

   public String getTitle() {
      return builder.build().getTitle();
   }

   public String getMessage() {
      return builder.build().getMessage();
   }

   public String getPositiveButtonText() {
      return builder.build().getPositiveButtonText();
   }

   public String getNegativeButtonText() {
      return builder.build().getNegativeButtonText();
   }

   public Listener getPositiveClickListener() {
      return positiveClickListener;
   }

   public Listener getNegativeClickListener() {
      return negativeClickListener;
   }

   public Listener getCancelListener() {
      return cancelListener;
   }

   public boolean isEnableAnimation() {
      return builder.build().isEnableAnimation();
   }

   public boolean isCancelable() {
      return builder.build().isCancelable();
   }

   public static class Builder {
      private final AppNotif appNotif;

      public Builder(Context context) {
         appNotif = new AppNotif(context);
      }

      public AppNotif build() {
         appNotif.builder.build();
         return appNotif;
      }

      public Builder title(String title) {
         appNotif.builder.title(title);
         return this;
      }

      public Builder message(String message) {
         appNotif.builder.message(message);
         return this;
      }

      public Builder setPositiveClickListener(String positiveButtonText, Listener positiveClickListener) {
         appNotif.positiveClickListener = positiveClickListener;
         appNotif.builder.positiveButtonText(positiveButtonText).positiveClickListener(new IOSDialog.Listener() {
            @Override
            public void onClick(IOSDialog iosDialog) {
               positiveClickListener.onClick(appNotif);
            }
         });
         return this;
      }

      public Builder setNegativeClickListener(String negativeButtonText, Listener negativeClickListener) {
         appNotif.negativeClickListener = negativeClickListener;
         appNotif.builder.negativeButtonText(negativeButtonText).negativeClickListener(new IOSDialog.Listener() {
            @Override
            public void onClick(IOSDialog iosDialog) {
               negativeClickListener.onClick(appNotif);
            }
         });
         return this;
      }

      public Builder setCancelListener(Listener cancelListener) {
         appNotif.cancelListener = cancelListener;
         appNotif.builder.cancelListener(new IOSDialog.Listener() {
            @Override
            public void onClick(IOSDialog iosDialog) {
               cancelListener.onClick(appNotif);
            }
         });
         return this;
      }

      public Builder enableAnimation(boolean enableAnimation) {
         appNotif.builder.enableAnimation(enableAnimation);
         return this;
      }

      public Builder cancelable(boolean cancelable) {
         appNotif.builder.cancelable(cancelable);
         return this;
      }
   }
}
