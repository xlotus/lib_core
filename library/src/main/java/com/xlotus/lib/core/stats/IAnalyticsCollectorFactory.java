package com.xlotus.lib.core.stats;

import android.content.Context;

import java.util.List;

public interface IAnalyticsCollectorFactory {
    List<BaseAnalyticsCollector> createCollectors(Context context);
}
