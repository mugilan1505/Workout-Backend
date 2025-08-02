-- Database Migration Script for Workout Guide App
-- Run this script to add video support and enhanced progress tracking

-- Add video_url column to workout table
ALTER TABLE workout ADD COLUMN video_url VARCHAR(255);

-- Add image_url column to workout table
ALTER TABLE workout ADD COLUMN image_url VARCHAR(255);

-- Add new fields to progress table for enhanced tracking
ALTER TABLE progress ADD COLUMN duration_minutes INTEGER;
ALTER TABLE progress ADD COLUMN calories_burned INTEGER;
ALTER TABLE progress ADD COLUMN notes TEXT;

-- Insert sample workout with video URL for testing
INSERT INTO workout (name, description, difficulty, body_part, duration, calories, instructions, equipment, video_url, image_url) 
VALUES (
    'Push-Up Challenge',
    'A comprehensive push-up workout that targets chest, shoulders, and triceps.',
    'Intermediate',
    'Chest',
    15,
    120,
    '1. Start in plank position\n2. Lower your body until chest nearly touches the floor\n3. Push back up to starting position\n4. Repeat for the specified duration',
    'None',
    'https://www.w3schools.com/html/mov_bbb.mp4',
    'https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=200&fit=crop'
);

-- Insert another sample workout
INSERT INTO workout (name, description, difficulty, body_part, duration, calories, instructions, equipment, video_url, image_url) 
VALUES (
    'Squat Master',
    'Lower body workout focusing on quads, hamstrings, and glutes.',
    'Beginner',
    'Legs',
    20,
    150,
    '1. Stand with feet shoulder-width apart\n2. Lower your body as if sitting back into a chair\n3. Keep your back straight and knees behind toes\n4. Return to standing position\n5. Repeat for the specified duration',
    'None',
    'https://www.w3schools.com/html/mov_bbb.mp4',
    'https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=200&fit=crop'
);

-- Insert a third sample workout
INSERT INTO workout (name, description, difficulty, body_part, duration, calories, instructions, equipment, video_url, image_url) 
VALUES (
    'Core Crusher',
    'Intensive core workout targeting abs and lower back.',
    'Advanced',
    'Core',
    25,
    180,
    '1. Start in plank position\n2. Engage your core muscles\n3. Hold the position while maintaining proper form\n4. Add variations like side planks and mountain climbers\n5. Complete the full duration',
    'Yoga Mat',
    'https://www.w3schools.com/html/mov_bbb.mp4',
    'https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=200&fit=crop'
);

-- Display confirmation
SELECT 'Database migration completed successfully!' as status; 