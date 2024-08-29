/**
 * @swagger
 * components:
 *   schemas:
 *     Profile:
 *       type: object
 *       properties:
 *         id:
 *           type: string
 *           description: The unique identifier of the profile.
 *         firstName:
 *           type: string
 *           description: The first name of the user.
 *         lastName:
 *           type: string
 *           description: The last name of the user.
 *         age:
 *           type: number
 *           description: The age of the user.
 *         email:
 *           type: string
 *           description: The email address of the user.
 *         address:
 *           type: string
 *           description: The address of the user.
 *         phone:
 *           type: string
 *           description: The phone number of the user.
 *         avatar:
 *           type: string
 *           description: The URL of the user's avatar.
 *       required:
 *         - id
 *         - firstName
 *         - lastName
 *         - age
 *         - email
 *         - address
 *         - phone
 *         - avatar
 */

// define class based on swagger spec
// also add helper class to get full-name of user
export class Profile {
	id: string;
	firstName: string;
	lastName: string;
	age: number;
	email: string;
	address: string;
	phone: string;
	avatar: string;

	constructor(data: Profile) {
		this.id = data.id;
		this.firstName = data.firstName;
		this.lastName = data.lastName;
		this.age = data.age;
		this.email = data.email;
		this.address = data.address;
		this.phone = data.phone;
		this.avatar = data.avatar;
	}

	get fullName(): string {
		return `${this.firstName} ${this.lastName}`;
	}
}
