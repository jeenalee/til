// The two code snippets will do the same thing.

// --------------------------------------------------------------
for byte in &value[first_index..last_index + 1] {
    normalized_value.push(*byte);   // dereferencing here
}

// --------------------------------------------------------------

for &byte in &value[first_index..last_index + 1] { // destructuring here
    normalized_value.push(byte);
}

