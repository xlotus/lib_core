package com.xlotus.lib.core.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.xlotus.lib.core.demo.databinding.ActivityMainBinding;
import com.xlotus.lib.core.utils.ui.SafeToast;

public class CoreDemoMainActivity extends BaseActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == binding.btnTest.getId()) {
            SafeToast.showToast("Test", Toast.LENGTH_SHORT);
        }
    }

}
