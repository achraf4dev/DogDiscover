# DogDiscover

DogDiscover is a web application that allows users to explore and learn about different dog breeds. The application provides detailed information about various dog breeds, including their characteristics, temperament, and history.

## Project Structure

### Templates

#### `src/main/resources/templates/layout.html`

This is the main layout template that serves as the foundation for all pages in the application. It includes:

- **HTML Structure**: Defines the basic HTML structure with proper meta tags and viewport settings.
- **Styling**: 
  - Integrates Tailwind CSS for responsive design
  - Includes Google Fonts (Poppins) for typography
  - Contains custom CSS for animations and styling
- **Navigation**: 
  - Responsive navigation bar with logo
  - Links to all dogs and breed group categories
  - Dropdown menu for breed groups
  - Mobile-friendly menu button
- **Footer**: 
  - Copyright information
  - Social media links with icons
- **Content Area**: A placeholder for page-specific content

The layout uses Thymeleaf's template inheritance system, allowing other templates to extend this base layout.

#### `src/main/resources/templates/dogs/list.html`

This template displays a grid of dog cards, showing a list of all available dog breeds. Features include:

- **Header Section**: 
  - Dynamic title that changes based on whether a breed group filter is applied
  - Descriptive subtitle
- **Dog Grid**: 
  - Responsive grid layout (1 column on mobile, 2 on small screens, 3 on medium, 4 on large)
  - Each dog card displays:
    - Dog image (with fallback for missing images)
    - Breed group badge (when available)
    - Dog name
    - Temperament (truncated to 2 lines)
    - "View Details" button
- **Empty State**: A message displayed when no dogs are found
- **Page Info**: Shows the total number of dogs being displayed

#### `src/main/resources/templates/dogs/detail.html`

This template displays detailed information about a specific dog breed. Features include:

- **Header Section**: 
  - Dog name and breed group
  - Back button to return to the list
- **Image Section**: 
  - Large dog image with fallback for missing images
- **Information Sections**:
  - Breed Information: Origin, lifespan, temperament
  - Physical Characteristics: Height, weight, colors
  - Description: Detailed breed description
  - History: Historical information about the breed
- **Styling**: 
  - Consistent with the application's design language
  - Icons for each section
  - Responsive layout

### Java Files

#### `src/main/java/com/example/dogdiscover/model/Dog.java`

This is the data model class that represents a dog breed. It includes:

- Properties for all dog attributes (id, name, breed group, temperament, etc.)
- Getters and setters for all properties
- Possibly annotations for JSON mapping (if using Jackson)

#### `src/main/java/com/example/dogdiscover/controller/DogController.java`

This controller handles HTTP requests related to dogs. It likely includes:

- Endpoints for:
  - Listing all dogs
  - Viewing a specific dog by ID
  - Filtering dogs by breed group
- Methods to fetch data from the Dog API
- Logic to process and prepare data for the templates

#### `src/main/java/com/example/dogdiscover/service/DogService.java`

This service class contains the business logic for the application. It likely includes:

- Methods to fetch dog data from the external API
- Data processing and transformation
- Caching mechanisms (if implemented)
- Error handling

#### `src/main/java/com/example/dogdiscover/DogDiscoverApplication.java`

This is the main Spring Boot application class that:

- Contains the `main` method to start the application
- Configures Spring Boot settings
- Possibly includes bean definitions and other configurations

## Technologies Used

- **Backend**: Spring Boot, Java
- **Frontend**: Thymeleaf, Tailwind CSS
- **API**: The Dog API (https://thedogapi.com/)
- **Styling**: Custom CSS, Google Fonts
- **Icons**: SVG icons

## Features

- Browse all dog breeds
- Filter dogs by breed group
- View detailed information about each breed
- Responsive design for all device sizes
- Modern UI with animations and transitions
- Fallback handling for missing images and data

## Getting Started

1. Clone the repository
2. Ensure you have Java and Maven installed
3. Run the application using `mvn spring-boot:run`
4. Access the application at `http://localhost:8080`

## API Integration

The application integrates with The Dog API to fetch dog breed data. This includes:
- Breed information
- Images
- Characteristics
- History

## Design Philosophy

The application follows a clean, modern design philosophy with:
- Warm amber color scheme appropriate for a dog-related website
- Consistent typography using Poppins font
- Card-based layout for easy scanning
- Responsive design that works on all devices
- Subtle animations for enhanced user experience 