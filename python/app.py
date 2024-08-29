from flask import Flask, jsonify, request, abort
app = Flask(__name__)

# User and Task classes
class User:
    def __init__(self, id, name, email):
        self.id = id
        self.name = name
        self.email = email
        self.tasks = []

    def to_dict(self):
        return {
            'id': self.id,
            'name': self.name,
            'email': self.email,
            'tasks': [task.to_dict() for task in self.tasks]
        }

    def update(self, name, email):
        self.name = name
        self.email = email

    def add_task(self, task):
        self.tasks.append(task)

    def __str__(self):
        str = f'User ID: {self.id} Name: {self.name} Email: {self.email} Tasks: '
        for task in self.tasks:
            str += f'\n{task}'
        return str

class Task:
    def __init__(self, id, title, description, done):
        self.id = id
        self.title = title
        self.description = description
        self.done = done

    def to_dict(self):
        return {
            'id': self.id,
            'title': self.title,
            'description': self.description,
            'done': self.done
        }

    def update(self, title, description, done):
        self.title = title
        self.description = description
        self.done = done

    def __str__(self):
        return f'Task ID: {self.id} Title: {self.title} Description: {self.description} Done: {self.done}'

# Helper Functions
def find_user(user_id):
    return next((user for user in users if user.id == user_id), None)

# User Endpoints

# Get all users
@app.route('/users', methods=['GET'])
def get_users():
    return jsonify([user.to_dict() for user in users])

# Get a user by ID
@app.route('/users/<int:user_id>', methods=['GET'])
def get_user(user_id):
    user = find_user(user_id)
    if not user:
        abort(404)
    return jsonify(user.to_dict())

# Create a new user
@app.route('/users', methods=['POST'])
def create_user():
    if not request.json or 'name' not in request.json or 'email' not in request.json:
        abort(400)
    user = User(len(users) + 1, request.json['name'], request.json['email'])
    users.append(user)
    return jsonify(user.to_dict()), 201

# Update a user
@app.route('/users/<int:user_id>', methods=['PUT'])
def update_user(user_id):
    user = find_user(user_id)
    if not user:
        abort(404)
    if not request.json:
        abort(400)
    user.update(request.json.get('name', user.name), request.json.get('email', user.email))
    return jsonify(user.to_dict())


# Delete a user
@app.route('/users/<int:user_id>', methods=['DELETE'])
def delete_user(user_id):
    user = find_user(user_id)
    if not user:
        abort(404)
    users.remove(user)
    return jsonify({'result': True})

# Task Endpoints
# Add a new endpoint to get all tasks for a user
# Add a new endpoint to create a task for a user
# Legg til et nytt endepunkt for å oppdatere en oppgave for en bruker



if __name__ == '__main__':
    task1 = Task(1, 'Task 1', 'Description 1', False)
    user1 = User(1, 'John Doe', 'john@example.com')
    user1.add_task(task1)
    users = [user1]

    for user in users:
        print(user)
    app.run(debug=True)
