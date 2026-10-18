# VangtiChai — CSE 489 Assignment 1

**Course:** CSE 489 — Mobile Application Development
**Assignment:** Assignment 1
**Project Name:** VangtiChai
**Programming Language:** Kotlin
**Development Environment:** Android Studio
**Layout:** Android XML, ConstraintLayout, and LinearLayout
**Minimum SDK:** API 21 (Android 5.0 Lollipop)

## 1. Project Description

VangtiChai is an Android application that calculates the number of Bangladeshi Taka notes required to make up an entered amount.

Users enter an amount using a custom numeric keypad, and the application automatically calculates the change using the following denominations:

500, 100, 50, 20, 10, 5, 2, and 1 Taka.

The application supports portrait and landscape orientations and uses alternative XML layouts and dimension resources to accommodate different screen sizes.

## 2. Features

- Custom numeric keypad containing digits 0–9.
- CLEAR button to reset the entered amount.
- Automatic calculation of Taka note denominations.
- Real-time updates when numeric buttons are pressed.
- Portrait and landscape layouts.
- Preservation of the entered amount during orientation changes.
- Responsive layouts for phones and tablets.
- ConstraintLayout-based interface design.
- Screen-size-specific dimension resources.
- Custom button styling and a teal-colored application header.

## 3. Application Functionality

The user enters an amount by pressing the numeric buttons.

Each digit is appended to the right of the current amount.

For example:

Press 6 → Amount: 6
Press 8 → Amount: 68
Press 8 → Amount: 688

For an amount of 688 Taka, the application displays:

500: 1
100: 1
50: 1
20: 1
10: 1
5: 1
2: 1
1: 1

The CLEAR button resets the amount and all denomination counts to zero.

## 4. Required Screen Configurations

The application was designed for the following assignment-specified screen dimensions:

| Device Configuration | Orientation | Screen Size |
|---|---|---|
| Pixel XL | Portrait | 411 × 731 dp |
| Pixel XL | Landscape | 731 × 411 dp |
| Nexus 10 | Portrait | 800 × 1280 dp |
| Nexus 10 | Landscape | 1280 × 800 dp |

Alternative layouts are provided for portrait and landscape orientations.

Separate dimension resources are used to support phone and tablet screen sizes.

## 5. Devices Used for Testing

The application was tested using the following Android emulator profiles:

**Device 1: Pixel 9 Pro XL**
- Device Type: Smartphone
- Emulator Profile: Pixel 9 Pro XL
- Android Version: Android 15 (API 35)
- Tested Orientations: Portrait and Landscape
- Used for testing the application's phone interface, keypad, and screen rotation.

**Device 2: Medium Tablet**
- Device Type: Tablet
- Emulator Profile: Medium Tablet
- Tested Orientations: Portrait and Landscape
- Used for testing the tablet interface, layout responsiveness, and screen rotation.

The emulator display settings were also adjusted using Android Debug Bridge (ADB) to target the screen dimensions specified in the assignment.

Target phone configuration:
- Resolution: 1440 × 2560 px
- Density: 560 dpi
- Approximate logical dimensions: 411 × 731 dp

Target tablet configuration:
- Resolution: 1600 × 2560 px
- Density: 320 dpi
- Logical dimensions: 800 × 1280 dp

These configurations approximate the required screen dimensions using available emulator hardware profiles rather than the original Pixel XL and Nexus 10 hardware profiles.

## 6. Layout Implementation

The application uses the following Android resource directories:

- `res/layout/` — Portrait layout
- `res/layout-land/` — Landscape layout
- `res/values/` — Default resources
- `res/values-land/` — Landscape dimension resources
- `res/values-sw600dp/` — Tablet dimension resources
- `res/values-sw600dp-land/` — Tablet landscape dimension resources

The interface uses ConstraintLayout and nested LinearLayouts.

Dimensions such as padding, margins, text sizes, and keypad heights are maintained in XML dimension resources to support different device configurations.

## 7. State Preservation

The application uses Android's `onSaveInstanceState()` mechanism to preserve the currently entered amount during Activity recreation.

When the orientation changes, the saved amount is restored and the denomination counts are recalculated.

## 8. Running the Application

1. Open the VangtiChai project in Android Studio.
2. Allow Gradle synchronization to complete.
3. Select an Android emulator or compatible physical device.
4. Build and run the application.
5. Enter an amount using the numeric keypad.
6. Observe the calculated Taka denominations.
7. Rotate the device to test the alternative layout.
8. Press CLEAR to reset the calculation.

## 9. Additional Devices Tested

In addition to the assignment's target screen configurations, the following emulator profiles were used:

- Pixel 9 Pro XL
- Medium Tablet

These devices were used to evaluate the application's appearance and responsiveness on modern phone and tablet configurations.

## 10. AI Usage

ChatGPT was used as a development and learning assistant for project setup, Kotlin and XML implementation, debugging, layout adjustments, and emulator configuration.

For additional information, see:

`docs/AI_Usage_Declaration.md`

## 11. Conclusion

VangtiChai demonstrates custom Android keypad implementation, Taka change calculation, responsive layouts, Android resource management, and state preservation during orientation changes.

The application was developed using Kotlin and XML in Android Studio for CSE 489 Assignment 1.