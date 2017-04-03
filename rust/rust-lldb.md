# Using `rust-lldb`

Here is a program that panics:
```
$ RUST_BACKTRACE=1 cargo run
   Compiling tv1d v0.1.0 (file:///Users/ljee/src/tv1d)
    Finished debug [unoptimized + debuginfo] target(s) in 0.43 secs
     Running `target/debug/tv1d`
RUST
average of the numbers in this list is: 4.925
input is: [1, 2.1, 5.2, 8.2, 1.4, 5.2, 6.2, 10.1]
lambda is: 0
thread 'main' panicked at 'index out of bounds: the len is 0 but the index is 0', /Users/rustbuild/src/rust-buildbot/slave/stable-dist-rustc-mac/build/src/libcollections/vec.rs:1371
stack backtrace:
   1:        0x10995031a - std::sys::imp::backtrace::tracing::imp::write::hd3b65cdfe843284c
   2:        0x10995169f - std::panicking::default_hook::{{closure}}::hf2b7428652613d83
   3:        0x109951347 - std::panicking::default_hook::h5da8f27db5582938
   4:        0x109951aa6 - std::panicking::rust_panic_with_hook::hcef1e67c646c6802
   5:        0x109951944 - std::panicking::begin_panic::hc2e8ca89533cd10d
   6:        0x109951862 - std::panicking::begin_panic_fmt::h60990696c3c3a88d
   7:        0x1099517c7 - rust_begin_unwind
   8:        0x1099779e0 - core::panicking::panic_fmt::h10231c789bd0e97d
   9:        0x109977958 - core::panicking::panic_bounds_check::hb351a373447937ca
  10:        0x109947175 - <collections::vec::Vec<T> as core::ops::IndexMut<usize>>::index_mut::h9e25d9d1c9efd8a1
  11:        0x109947ab5 - tv1d::tv1d_denoise_tautstring::hd15134290d3b7889
  12:        0x109947673 - tv1d::main::h82722b0757583d0c
  13:        0x10995349a - __rust_maybe_catch_panic
  14:        0x109951d16 - std::rt::lang_start::h87cb84a8b6cb187e
  15:        0x109949f39 - main
```

### Call `rust-lldb`

We're going to use `rust-lldb` on the build. For this case, it is a debug build:

```
$ rust-lldb ./target/debug/tv1d
(lldb) command source -s 0 '/tmp/rust-lldb-commands.cK8uHQ'
Executing commands in '/tmp/rust-lldb-commands.cK8uHQ'.
(lldb) command script import "/Users/ljee/.rustup/toolchains/stable-x86_64-apple-darwin/lib/rustlib/etc/lldb_rust_formatters.py"
(lldb) type summary add --no-value --python-function lldb_rust_formatters.print_val -x ".*" --category Rust
(lldb) type category enable Rust
(lldb) target create "./target/debug/tv1d"
Current executable set to './target/debug/tv1d' (x86_64).
```

### Set break point

```
(lldb) b rust_panic
Breakpoint 1: where = tv1d`std::panicking::rust_panic + 4 at panicking.rs:584, address = 0x000000010000eb34
```

### Run (the panicking) program

```
(lldb) r
Process 93345 launched: './target/debug/tv1d' (x86_64)
RUST
average of the numbers in this list is: 4.925
input is: [1, 2.1, 5.2, 8.2, 1.4, 5.2, 6.2, 10.1]
lambda is: 0
thread 'main' panicked at 'index out of bounds: the len is 0 but the index is 0', /Users/rustbuild/src/rust-buildbot/slave/stable-dist-rustc-mac/build/src/libcollections/vec.rs:1371
note: Run with `RUST_BACKTRACE=1` for a backtrace.
tv1d was compiled with optimization - stepping may behave oddly; variables may not be available.
Process 93345 stopped
* thread #1: tid = 0x1deffd, 0x000000010000eb34 tv1d`std::panicking::rust_panic + 4 at panicking.rs:584, queue = 'com.apple.main-thread', stop reason = breakpoint 1.1
    frame #0: 0x000000010000eb34 tv1d`std::panicking::rust_panic + 4 at panicking.rs:584 [opt]
```

### Start backtracing

The debugger will start walking backwards to find the origin of the panic. You can also use `n` to go to next. This will be helpful if the panic occurred in a helper function.

```
(lldb) bt
* thread #1: tid = 0x1deffd, 0x000000010000eb34 tv1d`std::panicking::rust_panic + 4 at panicking.rs:584, queue = 'com.apple.main-thread', stop reason = breakpoint 1.1
  * frame #0: 0x000000010000eb34 tv1d`std::panicking::rust_panic + 4 at panicking.rs:584 [opt]
    frame #1: 0x000000010000eb05 tv1d`std::panicking::rust_panic_with_hook + 437 at panicking.rs:569 [opt]
    frame #2: 0x000000010000e945 tv1d`std::panicking::begin_panic<collections::string::String> + 101 at panicking.rs:515 [opt]
    frame #3: 0x000000010000e863 tv1d`std::panicking::begin_panic_fmt + 147 at panicking.rs:499 [opt]
    frame #4: 0x000000010000e7c8 tv1d`std::panicking::rust_begin_panic + 56 at panicking.rs:475 [opt]
    frame #5: 0x00000001000349e1 tv1d`core::panicking::panic_fmt + 129 at panicking.rs:69 [opt]
    frame #6: 0x0000000100034959 tv1d`core::panicking::panic_bounds_check + 105 at panicking.rs:56 [opt]
    frame #7: 0x0000000100004176 tv1d`collections::vec::{{impl}}::index_mut<f32>(self=&0x7fff5fbff5e8, index=0) + 118 at vec.rs:1371
    frame #8: 0x0000000100004ab6 tv1d`tv1d::tv1d_denoise_tautstring(input=&0x7fff5fbff990, lambda=0) + 582 at main.rs:53
    frame #9: 0x0000000100004674 tv1d`tv1d::main + 820 at main.rs:17
    frame #10: 0x000000010001049b tv1d`panic_unwind::__rust_maybe_catch_panic + 27 at lib.rs:98 [opt]
    frame #11: 0x000000010000ed17 tv1d`std::rt::lang_start [inlined] std::panicking::try<(),fn()> + 44 at panicking.rs:434 [opt]
    frame #12: 0x000000010000eceb tv1d`std::rt::lang_start [inlined] std::panic::catch_unwind<fn(),()> at panic.rs:351 [opt]
    frame #13: 0x000000010000eceb tv1d`std::rt::lang_start + 347 at rt.rs:57 [opt]
    frame #14: 0x0000000100006f3a tv1d`main + 42
    frame #15: 0x00007fff990b35ad libdyld.dylib`start + 1
```

### Go up a frame

`up` takes you to the older frame.

```
(lldb) up
frame #1: 0x000000010000eb05 tv1d`std::panicking::rust_panic_with_hook + 437 at panicking.rs:569 [opt]
(lldb) up
frame #2: 0x000000010000e945 tv1d`std::panicking::begin_panic<collections::string::String> + 101 at panicking.rs:515 [opt]
(lldb) up
frame #3: 0x000000010000e863 tv1d`std::panicking::begin_panic_fmt + 147 at panicking.rs:499 [opt]
(lldb) up
frame #4: 0x000000010000e7c8 tv1d`std::panicking::rust_begin_panic + 56 at panicking.rs:475 [opt]
(lldb) up
frame #5: 0x00000001000349e1 tv1d`core::panicking::panic_fmt + 129 at panicking.rs:69 [opt]
(lldb) up
frame #6: 0x0000000100034959 tv1d`core::panicking::panic_bounds_check + 105 at panicking.rs:56 [opt]
(lldb) up
frame #7: 0x0000000100004176 tv1d`collections::vec::{{impl}}::index_mut<f32>(self=&0x7fff5fbff5e8, index=0) + 118 at vec.rs:1371
```

We've reached the source of panic! The panic message was:
```
thread 'main' panicked at 'index out of bounds: the len is 0 but the index is 0'
```

And the source of panic is:
```
(lldb) up
frame #8: 0x0000000100004ab6 tv1d`tv1d::tv1d_denoise_tautstring(input=&0x7fff5fbff990, lambda=0) + 582 at main.rs:53
   50
   51  	    let mut output = Vec::new();
   52
-> 53  	    y_low[0] = 0.0;
   54  	    y_up[0] = 0.0;
   55
   56  	    y_low[1] = input[0] - lambda;

```
The program was trying to access the 0th element of an empty vector.

### Print things with the debugger
We can confirm that the vector `y_low` is indeed empty.

```
(lldb) p y_low
(collections::vec::Vec<f32>) $0 = vec![]
```
