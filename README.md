# MedicineInventoryManagement
This repo is consist of three microservices in different branches and UI code.
1. Admin-Microservice: Admin login and registration using JWT Authentication and Authorization.
2. Employee-Microservice: Employee login and registration using JWT Authentication and Authorization.
3. Inventory-Microserive: Manage - Medicine Inventory, Orders, Requests.
4. Frontend: Consists of UI code.

## Each member role:

### Aman Dhaka role in this project
1. Implemented two microservices i.e Employee and Admin.
2. Created APIs for user's login and registeration part.
3. Also created an api for admin role and used feign client to communicate with employee microservice.
4. Implemented JWT authentication and Authorization using spring boot security on Employee and Admin Mircoservice.
5. Worked on fronted to call few API in the frontend - for search, register, login, get-employee list.
6. Also created couple of user interfaces components - navigation bar, displaying data in tabular format.

### Srikanta Vaibhav N. role in this project:
1.Implemented 1 microservice (Inventory microservice).
2.Created 16 APIs for Medicine, Category, Order and Request services.
	-Medicine: create, update, delete, view item, view list, view by category, view medicine to order (i.e. out of stock, low in stock and expired medicines).
	-Category: create, and view category.
	-Order: create, view list, and delete order.-
	-Request: create, view list, update, and delete request.
3.Learnt how to integrate few APIs of Medicine on the frontend.

### Utkarsh Ashish role in this project:
1. I implemented the following things in my group project:
2.Frontend Development of pages (Login Page, Registration Page, Admin Page, Employee Page and other pages also)
3.Adding the animation for icons and background images and pop-out feature of login page.
4.API integration of Manage Order page in admin - create order, update order, view order and delete order.
5.Animation of Admin Page including the text animation.
6.Form validation and alert generation on submitting the forms. 

### Meghna role in this project:
1.API integration of Manage Inventory page in admin - add an item, update an item, delete an item
2.API integration of Manage Request page in admin - view all requests, update an existing request, delete a request
3.API integration of create request from employee page
4.Form generation and hide/unhide forms on clicking on the button
5.Menu pop out feature on the admin page


## How to run this project: 
For running frontend branch code: 
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

For running spring boot microservices:
Clone the repository and install maven dependencies.
