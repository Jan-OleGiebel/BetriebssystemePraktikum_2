cmake_minimum_required(VERSION 3.16)

# Project name (doesn't affect executable)
project(my_project C)

# Set C standard
set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)

# Add executable and explicitly name it 'hawsh'
add_executable(hawsh hawsh.c)

# Optional: include directories if you have headers
# target_include_directories(hawsh PRIVATE include)
