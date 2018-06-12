package com.arrk.arrktest.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.arrk.arrktest.R;
import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.utils.BundleContants;
import com.arrk.arrktest.utils.DateTimeUtils;
import com.arrk.arrktest.utils.MeasureUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.nameval)
    TextView nameVal;

    @BindView(R.id.heightval)
    TextView heightVal;

    @BindView(R.id.weightval)
    TextView weightVal;

    @BindView(R.id.dateval)
    TextView dateVal;

    @BindView(R.id.timeval)
    TextView timeVal;


    private StarWarCharacter character;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        if (getIntent().hasExtra(BundleContants.STAR_CHARACTER_KEY)) {
            character = getIntent().getParcelableExtra(BundleContants.STAR_CHARACTER_KEY);
            showDetail(character);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void showDetail(StarWarCharacter character) {
        nameVal.setText(character.getName());
        MeasureUtils measureUtils = new MeasureUtils();
        String heightInMeters = measureUtils.convertToMeters(character.getHeight());
        heightInMeters = !TextUtils.isEmpty(heightInMeters) ? heightInMeters : getString(R.string.not_available);
        heightVal.setText(heightInMeters);
        weightVal.setText(character.getMass());
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        String created = character.getCreated();
        created = !TextUtils.isEmpty(created) ? created : getString(R.string.not_available);
        dateVal.setText(dateTimeUtils.getDate(created));
        timeVal.setText(dateTimeUtils.getTime(created));

    }

}
