document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('login-form');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');
    const emailError = document.getElementById('email-error');
    const passwordError = document.getElementById('password-error');
    const formMessage = document.getElementById('form-message');
    const togglePassword = document.getElementById('toggle-password');
    const loginButton = document.getElementById('login-button');

    // Toggle password visibility
    togglePassword.addEventListener('click', function() {
        const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordInput.setAttribute('type', type);
        togglePassword.querySelector('i').classList.toggle('fa-eye');
        togglePassword.querySelector('i').classList.toggle('fa-eye-slash');
    });

    // Real-time validation for email
    emailInput.addEventListener('input', function() {
        validateEmail();
    });

    // Real-time validation for password
    passwordInput.addEventListener('input', function() {
        validatePassword();
    });

    // Form submission
    loginForm.addEventListener('submit', function(e) {
        e.preventDefault();

        // Clear previous messages
        formMessage.textContent = '';
        formMessage.className = 'form-message';

        // Validate all fields
        const isEmailValid = validateEmail();
        const isPasswordValid = validatePassword();

        if (isEmailValid && isPasswordValid) {
            // Simulate API call with setTimeout
            loginButton.disabled = true;
            loginButton.textContent = 'Logging in...';

            setTimeout(function() {
                // Simulate authentication check
                const mockUsers = [
                    { email: 'user@example.com', password: 'Password123' },
                    { email: 'admin@example.com', password: 'Admin123' }
                ];

                const user = mockUsers.find(u => u.email === emailInput.value);

                if (user && user.password === passwordInput.value) {
                    // Successful login
                    formMessage.textContent = 'Login successful! Redirecting...';
                    formMessage.className = 'form-message success';

                    // Simulate redirect
                    setTimeout(function() {
                        alert('Redirect to dashboard (simulation)');
                    }, 1500);
                } else if (user) {
                    // User exists but password is incorrect
                    formMessage.textContent = 'Incorrect password. Please try again.';
                    formMessage.className = 'form-message error';
                } else {
                    // User doesn't exist
                    formMessage.textContent = 'User not found. Please check your email or register.';
                    formMessage.className = 'form-message error';
                }

                loginButton.disabled = false;
                loginButton.textContent = 'Login';
            }, 1500);
        }
    });

    // Validation functions
    function validateEmail() {
        const value = emailInput.value.trim();
        let isValid = true;

        if (value === '') {
            emailError.textContent = 'Email is required';
            isValid = false;
        } else if (!isValidEmail(value)) {
            emailError.textContent = 'Please enter a valid email address';
            isValid = false;
        } else {
            emailError.textContent = '';
        }

        highlightInput(emailInput, isValid);
        return isValid;
    }

    function validatePassword() {
        const value = passwordInput.value;
        let isValid = true;

        if (value === '') {
            passwordError.textContent = 'Password is required';
            isValid = false;
        } else if (value.length < 6) {
            passwordError.textContent = 'Password must be at least 6 characters';
            isValid = false;
        } else {
            passwordError.textContent = '';
        }

        highlightInput(passwordInput, isValid);
        return isValid;
    }

    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    function highlightInput(input, isValid) {
        if (isValid) {
            input.style.borderColor = '#e0e0e0';
            input.style.boxShadow = 'none';
        } else {
            input.style.borderColor = '#f44336';
            input.style.boxShadow = '0 0 0 2px rgba(244, 67, 54, 0.1)';
        }
    }
});