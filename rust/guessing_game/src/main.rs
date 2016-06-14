extern crate rand;

use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {
    println!("Guess a number!");

    // `secret_number` is immutable.
    // `rand::thread_rng()` generates a random number.
    let secret_number = rand::thread_rng().gen_range(1, 101);

    // If you want to print secret_number, uncomment below.
    // println!("The secret number is {}:", secret_number);

    // This loops until the user guesses correctly.
    loop {
        //
        println!("Please input your guess");

        // Objects are immutable by default in Rust.
        // Specify that `guess` is mutable.
        let mut guess = String::new();

        // Reassign previously generated `guess` to
        // the input from the user.
        io::stdin().read_line(&mut guess)
            // In Rust, you have to specify the exception.
            .expect("Failed to read line");

        // `trim` removes white space.
        // `parse` makes it into a u32.
        let guess: u32 = match guess.trim().parse() { 
            // `Ok(num) means there was no error.
            // In that case, whatever is returned becomes `num`.
            // `guess` becomes `num`
            Ok(num) => num,
            // If an error is returned, ignore it
            // and repeat the loop.
            Err(_)  => continue,
        };

        println!("You guessed: {}", guess);

        // `secret_number` is immutable, so when referring to it,
        // it requires `&`, not `&mut`.
        // Compare `guess` to `secret_number`.
        match guess.cmp(&secret_number) {
            Ordering::Less      => println!("Too small!"),
            Ordering::Greater   => println!("Too large!"),
            Ordering::Equal     => {
                println!("You win!");
                break;
            }
        }
    }
}
