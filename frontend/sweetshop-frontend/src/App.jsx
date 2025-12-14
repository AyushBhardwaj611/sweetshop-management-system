import React, { useState, useEffect } from 'react';

function App() {
  const [sweets, setSweets] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Replace the URL with your backend endpoint
    fetch('http://localhost:8080/sweets')
      .then((res) => res.json())
      .then((data) => {
        setSweets(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error('Error fetching sweets:', err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading sweets...</p>;
  }

  return (
    <div style={{ padding: '2rem', fontFamily: 'sans-serif' }}>
      <h1>Sweet Shop Management</h1>
      {sweets.length === 0 ? (
        <p>No sweets available</p>
      ) : (
        <ul>
          {sweets.map((sweet) => (
            <li key={sweet.id}>
              <strong>{sweet.name}</strong> - ₹{sweet.price}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
