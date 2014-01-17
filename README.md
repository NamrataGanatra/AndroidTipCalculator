AndroidTipCalculator
====================

Tip calculator project for Android
Couple of extras along with basic functionalities:
1) Using a NumberPicker control (instead of standard buttons) for choosing Tip %.
2) Tried changing theme for the app and styles in TipCalculator.Manifest file for changing the styles for NumberPicker
   (wanted to show + and - sign for the number picker)
3) All text values are in values/strings.xml for better localization
4) Implemented 2 event listeners upon which it reculates the tip amount and total amount:
   a) TextChangedListener for EditText control. If the Bill amount changes then update the total.
   b) ValueChangedListener for NumberPicker control. If the tip % changes then cupdate the tip amount and total.
5) From the UI perspective, tried nested layouts and implemented custom drawable shape for giving rounded border
   to the relative layout.
