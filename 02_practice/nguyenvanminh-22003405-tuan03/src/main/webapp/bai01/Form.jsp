<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border: 2px solid #007bff;
            border-radius: 8px;
            background-color: #f8f9fa;
        }

        .form-title {
            text-align: center;
            background-color: #e9ecef;
            margin: -20px -20px 20px -20px;
            padding: 15px;
            border-radius: 6px 6px 0 0;
            font-weight: bold;
            border-bottom: 1px solid #dee2e6;
        }

        .qualification-table {
            width: 100%;
            margin-top: 10px;
        }

        .qualification-table th,
        .qualification-table td {
            border: 1px solid #dee2e6;
            padding: 8px;
            text-align: center;
        }

        .qualification-table th {
            background-color: #e9ecef;
            font-weight: bold;
        }

        .btn-submit {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-reset {
            background-color: #6c757d;
            border-color: #6c757d;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <div class="form-title">Student Registration Form</div>

        <form action="${pageContext.request.contextPath}/student" method="post">
            <!-- Personal Information -->
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName">
                </div>
                <div class="col-md-6">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="dateOfBirth" class="form-label">Date of Birth</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth"
                           placeholder="dd/mm/yyyy">
                </div>
                <div class="col-md-6">
                    <label for="mobile" class="form-label">Mobile</label>
                    <input type="tel" class="form-control" id="mobile" name="mobile">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Gender</label>
                    <div class="mt-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                            <label class="form-check-label" for="male">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                            <label class="form-check-label" for="female">Female</label>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Address Information -->
            <div class="row mb-3">
                <div class="col-12">
                    <label for="address" class="form-label">Address</label>
                    <textarea class="form-control" id="address" name="address" rows="3"></textarea>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="city" class="form-label">City</label>
                    <input type="text" class="form-control" id="city" name="city">
                </div>
                <div class="col-md-6">
                    <label for="pinCode" class="form-label">Pin Code</label>
                    <input type="text" class="form-control" id="pinCode" name="pinCode">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="state" class="form-label">State</label>
                    <input type="text" class="form-control" id="state" name="state">
                </div>
                <div class="col-md-6">
                    <label for="country" class="form-label">Country</label>
                    <select class="form-select" id="country" name="country">
                        <option value="">Select Country</option>
                        <option value="india" selected>INDIA</option>
                        <option value="usa">USA</option>
                        <option value="uk">UK</option>
                        <option value="canada">Canada</option>
                    </select>
                </div>
            </div>

            <!-- Hobbies -->
            <div class="row mb-3">
                <div class="col-12">
                    <label class="form-label">Hobbies</label>
                    <div class="mt-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="drawing" name="hobbies" value="drawing">
                            <label class="form-check-label" for="drawing">Drawing</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="singing" name="hobbies" value="singing">
                            <label class="form-check-label" for="singing">Singing</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="dancing" name="hobbies" value="dancing">
                            <label class="form-check-label" for="dancing">Dancing</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="sketching" name="hobbies"
                                   value="sketching">
                            <label class="form-check-label" for="sketching">Sketching</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="others" name="hobbies" value="others">
                            <label class="form-check-label" for="others">Others</label>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Qualification Table -->
            <div class="row mb-3">
                <div class="col-12">
                    <label class="form-label fw-bold">Qualification</label>
                    <table class="qualification-table table table-bordered">
                        <thead>
                        <tr>
                            <th>SI No</th>
                            <th>Examination</th>
                            <th>Board</th>
                            <th>Percentage</th>
                            <th>Year of Passing</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Class X</td>
                            <td><input type="text" class="form-control form-control-sm" name="board1"></td>
                            <td><input type="text" class="form-control form-control-sm" name="percentage1"></td>
                            <td><input type="text" class="form-control form-control-sm" name="year1"></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Class XII</td>
                            <td><input type="text" class="form-control form-control-sm" name="board2"></td>
                            <td><input type="text" class="form-control form-control-sm" name="percentage2"></td>
                            <td><input type="text" class="form-control form-control-sm" name="year2"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Course Applied For -->
            <div class="row mb-4">
                <div class="col-12">
                    <label class="form-label">Course applied for</label>
                    <div class="mt-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="course" id="bca" value="bca">
                            <label class="form-check-label" for="bca">BCA</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="course" id="bcom" value="bcom">
                            <label class="form-check-label" for="bcom">B.Com</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="course" id="bsc" value="bsc">
                            <label class="form-check-label" for="bsc">B.Sc</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="course" id="ba" value="ba">
                            <label class="form-check-label" for="ba">B.A</label>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Submit Buttons -->
            <div class="row">
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary btn-submit me-2">Submit</button>
                    <button type="reset" class="btn btn-secondary btn-reset">Reset</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>