package edu.wgu.android.studentscheduler.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import edu.wgu.android.studentscheduler.R;
import edu.wgu.android.studentscheduler.domain.assessment.Assessment;
import edu.wgu.android.studentscheduler.domain.assessment.AssessmentType;

public class AssessmentDetailsActivity extends StudentSchedulerActivity {

    public AssessmentDetailsActivity() {
        super(R.layout.activity_assessment_detail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        Assessment assessment = (Assessment) extras.getSerializable(ASSESSMENT_OBJECT_BUNDLE_KEY);
        ((EditText)findViewById(R.id.assessmentNameEditText)).setText(assessment.getName());
        ((EditText)findViewById(R.id.assessmentCodeEditText)).setText(assessment.getCode());
        ((EditText)findViewById(R.id.assessmentDateEditText)).setText(assessment.getAssessmentDate());

        setTypeButton(assessment);
    }

    private void setTypeButton(Assessment assessment) {
        AssessmentType type = assessment.getType();
        switch (type) {
            case PERFORMANCE:
                ((RadioButton) findViewById(R.id.performanceAssessmentButton)).setChecked(true);
                break;
            case OBJECTIVE:
                ((RadioButton) findViewById(R.id.objectiveAssessmentButton)).setChecked(true);
                break;
            default:
                Toast.makeText(this, type.getType() + " is not yet supported. How did we get here?", Toast.LENGTH_SHORT).show();
        }
    }

}
