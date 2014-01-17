package com.mobileapps.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class TipCalculator extends Activity {
	
	EditText billAmountView;
	TextView totalTipView;
	TextView totalAmountView;
	int tipPercentage;
	float totalTip;
	float totalAmount;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		billAmountView = (EditText) findViewById(R.id.edtAmount);
		totalTipView = (TextView) findViewById(R.id.txtTipValue);
		totalAmountView = (TextView) findViewById(R.id.txtTotalValue);
		NumberPicker tipPicker = (NumberPicker) findViewById(R.id.tipPicker);
		// set the minimum value and max value for the tip picker
		tipPicker.setWrapSelectorWheel(true);
		tipPicker.setMinValue(0);
		tipPicker.setMaxValue(50);
		tipPicker.setBackgroundColor(Color.CYAN);
		tipPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				tipPercentage = newVal;
				displayTotal(billAmountView.getText().toString());
			}
		});
		
		billAmountView.addTextChangedListener( new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// the text is changed at this point
				displayTotal(s.toString());
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	// Calculate and display the tip total and amount total
	private void displayTotal(String billAmount)
	{
		float billAmountValue;
		
		try
		{
			billAmountValue = Float.parseFloat(billAmount);
		}
		catch(NumberFormatException e)
		{
			billAmountValue = 0f;
		}
		
		totalTip = billAmountValue * (tipPercentage / 100f);
		totalAmount = billAmountValue + totalTip;
		totalTipView.setText(String.format("$%.2f",totalTip));
		totalAmountView.setText(String.format("$%.2f",totalAmount));
	}

}
