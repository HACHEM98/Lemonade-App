# Lemonade App
## Overview
The Lemonade App is a fun, interactive Android application built using Jetpack Compose. The app guides users through a series of steps to make lemonade, with playful interactions involving a lemon tree, squeezing lemons, drinking lemonade, and restarting the process.
## Key Features:
- Interactive lemon-making process.
- Dynamic UI that updates based on user actions.
- Clickable images to transition through different stages of lemonade making.
- Scaffold-based UI structure using Material 3 design components.
## Project Structure
- MainActivity.kt: The main entry point for the app, sets up the UI using Jetpack Compose.
- LemonadeApp(): Composable function that defines the main app structure, including a top bar and content scaffold.
- LemonadeProcess(): Contains the logic for switching between the different steps of making lemonade (lemon tree, squeezing, drinking, and restart).
## Steps in the App
- Step 1: Tap the lemon tree to pick a lemon.
- Step 2: Squeeze the lemon multiple times until all juice is extracted.
- Step 3: Drink the lemonade.
- Step 4: Restart the process with an empty glass.
## Setup Instructions
### Prerequisites: 
- Android Studio .
- Kotlin 1.8.0 .
- Min SDK: 24
- Target SDK: 34
### Build Instructions:
1. Clone the repository.
   ```bash
   git clone https://github.com/username/lemonade-app.git

2. Open the project in Android Studio.
3. Sync the project with Gradle by clicking on Sync Now when prompted.
4. Run the app on an Android emulator or a physical device.
## Technologies Used:
- Kotlin: Primary language for Android development.
- Jetpack Compose: Modern UI toolkit used to create declarative UI components.
- Material 3: For UI components and theming.
- AndroidX libraries:
   - androidx.lifecycle:lifecycle-runtime-ktx
   - androidx.activity:activity-compose
   - androidx.core:core-ktx
## How the App Works:
1. UI Interaction: Users interact with clickable images that change based on the current step of the lemonade-making process.
2. State Management: The app uses remember and mutableStateOf to keep track of the current step and squeeze count.
3. Dynamic Content: Images and texts are dynamically loaded based on the current step using painterResource and stringResource.

## Screenshots
![Dice Roller Screenshot](screenshots/dice_roller.png)
## License
This project is licensed under the MIT License .
