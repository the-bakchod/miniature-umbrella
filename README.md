# NotesApp

A modern Android notes application built with Kotlin and Jetpack Compose. This app allows users to create, edit, organize, and manage notes with support for folders, pinning, colors, and images.

## Features

- ✨ **Create and Edit Notes**: Simple and intuitive note creation and editing interface
- 📌 **Pin Notes**: Keep important notes at the top of your list
- 🎨 **Color Coding**: Customize notes with different colors for better organization
- 📁 **Folder Organization**: Organize notes into folders for better management
- 🖼️ **Image Support**: Attach images to your notes
- 💾 **Persistent Storage**: All notes are saved locally using Room database
- 🎯 **Material Design 3**: Modern UI built with Material Design 3 components
- 🔄 **Reactive UI**: Uses Kotlin Flow for reactive data updates

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room Persistence Library
- **Dependency Injection**: Manual DI with ViewModelFactory
- **Navigation**: Navigation Compose
- **Build System**: Gradle (Kotlin DSL)
- **Minimum SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)

## Dependencies

- **Jetpack Compose**: Modern declarative UI toolkit
- **AndroidX Navigation**: For screen navigation
- **Room Database**: For local data persistence
- **Kotlin Coroutines**: For asynchronous programming
- **Lifecycle Components**: ViewModel and LiveData
- **Material Design 3**: For UI components

## Prerequisites

Before you begin, ensure you have the following installed:

- **Android Studio**: Hedgehog (2023.1.1) or newer
- **JDK**: Java 17 or newer
- **Android SDK**: With SDK 34 installed
- **Gradle**: 8.x (included via Gradle Wrapper)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/the-bakchod/miniature-umbrella.git
   cd miniature-umbrella
   ```

2. **Open in Android Studio**:
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned repository and open it

3. **Sync Gradle**:
   - Android Studio will automatically prompt you to sync Gradle
   - Wait for the sync to complete

4. **Configure local.properties** (if needed):
   - The `local.properties` file should already exist
   - Ensure it points to your Android SDK location:
     ```properties
     sdk.dir=/path/to/your/android/sdk
     ```

## Building the App

### Using Android Studio

1. Select a device or emulator
2. Click the "Run" button (▶️) or press `Shift + F10`

### Using Command Line

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

## Running Tests

### Unit Tests

```bash
./gradlew test
```

### Instrumented Tests

```bash
./gradlew connectedAndroidTest
```

### Run all tests

```bash
./gradlew check
```

## Project Structure

```
miniature-umbrella/
├── src/
│   ├── main/
│   │   ├── java/com/example/notesapp/
│   │   │   ├── data/              # Data layer
│   │   │   │   ├── Note.kt        # Note entity
│   │   │   │   ├── Folder.kt      # Folder entity
│   │   │   │   ├── NoteDao.kt     # Note data access object
│   │   │   │   ├── FolderDao.kt   # Folder data access object
│   │   │   │   ├── NoteDatabase.kt # Room database
│   │   │   │   └── repository/    # Repository pattern
│   │   │   ├── viewModel/         # ViewModels
│   │   │   │   ├── NoteListViewModel.kt
│   │   │   │   ├── NoteEditorViewModel.kt
│   │   │   │   ├── FolderListViewModel.kt
│   │   │   │   └── ViewModelFactory.kt
│   │   │   ├── ui/                # UI layer
│   │   │   │   ├── screen/        # Compose screens
│   │   │   │   ├── theme/         # Theme and styling
│   │   │   │   └── NavGraph.kt    # Navigation graph
│   │   │   └── MainActivity.kt    # Main activity
│   │   └── AndroidManifest.xml
│   └── test/                      # Unit tests
├── build.gradle.kts               # Build configuration
├── settings.gradle.kts            # Gradle settings
└── gradle.properties              # Gradle properties
```

## Usage

### Creating a Note

1. Launch the app
2. Tap the floating action button (➕)
3. Enter your note title and content
4. Optionally:
   - Choose a color for the note
   - Add an image
   - Assign to a folder
5. Save the note

### Organizing Notes

- **Pin a Note**: Tap the pin icon to keep the note at the top
- **Change Color**: Select a color to visually organize your notes
- **Create Folders**: Use folders to categorize related notes
- **Edit**: Tap any note to edit its content

### Managing Folders

- Create new folders from the folder management screen
- Assign notes to folders for better organization
- Delete folders (notes will remain in the main list)

## Development

### Code Style

This project follows Kotlin coding conventions:
- Use meaningful variable and function names
- Follow MVVM architecture pattern
- Keep composables small and focused
- Use state hoisting in Compose

### Adding New Features

1. Create/modify data models in the `data` package
2. Update DAOs and Repository as needed
3. Implement ViewModel logic
4. Create/update Compose UI in the `ui` package
5. Update navigation if adding new screens
6. Add tests for new functionality

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is currently not licensed. Please contact the repository owner for usage permissions.

## Version History

- **v1.0.0** - Initial working prototype
  - Basic note creation and editing
  - Folder support
  - Pin functionality
  - Color coding
  - Image attachments

## Contact

For questions or feedback, please open an issue on the GitHub repository.

---

Made with ❤️ using Kotlin and Jetpack Compose
