-- Sample data
INSERT INTO categories (name, description) 
VALUES ('Mild Steel Materials', 'Raw mild steel stock: flats, angles, channels, rounds, plates');

INSERT INTO categories (name, description) 
VALUES ('Fasteners', 'Bolts, nuts, washers, etc.');

INSERT INTO materials (name, sku, unit, quantity, min_quantity, location, notes, category_id)
VALUES
('MS Flat 50x6', 'MSF-50x6', 'kg', 1200.50, 50, 'Rack MS-A1', 'Used for chassis frames', 1),
('MS Angle 40x40x5', 'MSA-40x40x5', 'kg', 800.00, 30, 'Rack MS-A2', 'Angle used for bracing', 1),
('MS Channel 100x50', 'MSC-100x50', 'kg', 350.25, 20, 'Rack MS-A3', 'Channel for beams', 1),
('Hex Bolt M16x60', 'BOLT-M16-60', 'piece', 2000, 200, 'Small Box 1', 'Grade 8.8', 2),
('Hex Nut M16', 'NUT-M16', 'piece', 3000, 500, 'Small Box 2', 'Matched bolts', 2);
