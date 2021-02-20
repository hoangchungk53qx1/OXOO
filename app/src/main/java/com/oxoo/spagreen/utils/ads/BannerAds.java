package com.oxoo.spagreen.utils.ads;

import android.content.Context;
import android.os.Bundle;


import android.widget.RelativeLayout;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.ixidev.gdpr.GDPRChecker;
import com.oxoo.spagreen.database.DatabaseHelper;
import com.oxoo.spagreen.network.model.config.AdsConfig;
import com.startapp.android.publish.ads.banner.Banner;


public class BannerAds {

    public static void ShowAdmobBannerAds(Context context, RelativeLayout mAdViewLayout) {
        AdsConfig adsConfig = new DatabaseHelper(context).getConfigurationData().getAdsConfig();

        AdView mAdView = new AdView(context);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(adsConfig.getAdmobBannerAdsId());
        AdRequest.Builder builder = new AdRequest.Builder();
        GDPRChecker.Request request = GDPRChecker.getRequest();

        if (request == GDPRChecker.Request.NON_PERSONALIZED) {
            // load non Personalized ads
            Bundle extras = new Bundle();
            extras.putString("npa", "1");
            builder.addNetworkExtrasBundle(AdMobAdapter.class, extras);
        } // else do nothing , it will load PERSONALIZED ads
        mAdView.loadAd(builder.build());
        mAdViewLayout.addView(mAdView);

    }

    public static void showStartAppBanner(Context context, final RelativeLayout mainLayout) {
        // Create new StartApp banner
        Banner startAppBanner = new Banner(context);
        RelativeLayout.LayoutParams bannerParameters =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bannerParameters.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        // Add the banner to the main layout
        mainLayout.addView(startAppBanner, bannerParameters);
    }

    public static void showFANBanner(Context context, RelativeLayout mAdViewLayout) {
        AdsConfig adsConfig = new DatabaseHelper(context).getConfigurationData().getAdsConfig();

        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(context, adsConfig.getFanBannerAdsPlacementId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        mAdViewLayout.addView(adView);
        // Request an ad
        adView.loadAd();
    }

}
