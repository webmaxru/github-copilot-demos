import React, { useState } from 'react';

const Dashboard: React.FC = () => {
    const [data, setData] = useState<string[]>([]);
    const [loading, setLoading] = useState<boolean>(false);

    const fetchData = () => {
        setLoading(true);
        setTimeout(() => {
            setData(['Item 1', 'Item 2', 'Item 3']);
            setLoading(false);
        }, 2000);
    };

    return (
        <div>
            <h1>Dashboard</h1>
            <button onClick={fetchData}>Fetch Data</button>
            {loading ? (
                <p>Loading...</p>
            ) : (
                <ul>
                    {data.map((item, index) => (
                        <li key={index}>{item}</li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default Dashboard;