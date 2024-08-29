import { Profile } from './models';

interface ProfileProps {
	profile: Profile;
}

const ProfilePage = ({ profile: { firstName, lastName } }: ProfileProps) => {
	return (
		<div>
			<h1>
				{firstName} {lastName}
			</h1>
		</div>
	);
};

export default ProfilePage;
